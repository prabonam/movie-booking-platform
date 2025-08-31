package com.xyz.booking.service;

 
import com.xyz.booking.dto.BookingRequest;
import com.xyz.booking.dto.BookingResponse;
import com.xyz.booking.entity.*;
import com.xyz.booking.repository.*;
import com.xyz.booking.strategy.DiscountContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final DiscountEngine discountEngine;

    /**
     * Books the requested seats for the show. Simple locking/reservation approach:
     * - Check seat exists and not booked
     * - Mark booked = true and save (this is naive and for demo; for production we need DB locking / optimistic locking or seat reservation workflow)
     */
    @Transactional
    public BookingResponse book(BookingRequest req) {
        Show show = showRepository.findById(req.showId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid showId"));

        int seatCount = req.seats().size();
        int pricePerSeat = show.getPriceCents();
        int subtotal = pricePerSeat * seatCount;

        // Reserve seats
        for (String seat : req.seats()) {
            var seatEntity = showSeatRepository.findByShow_IdAndSeatNumber(show.getId(), seat)
                    .orElseThrow(() -> new IllegalArgumentException("Seat not found: " + seat));
            if (seatEntity.isBooked()) {
                throw new IllegalStateException("Seat already booked: " + seat);
            }
            seatEntity.setBooked(true);
            showSeatRepository.save(seatEntity);
        }

        int discount = discountEngine.calculateDiscountCents(subtotal, new DiscountContext(show, seatCount));
        int total = subtotal - discount;

        Booking booking = Booking.builder()
                .userId(req.userId())
                .show(show)
                .seatCount(seatCount)
                .subtotalCents(subtotal)
                .discountCents(discount)
                .totalCents(total)
                .status(BookingStatus.CONFIRMED)
                .createdAt(OffsetDateTime.now())
                .build();

        booking = bookingRepository.save(booking);

        for (String seat : req.seats()) {
            var seatEntity = showSeatRepository.findByShow_IdAndSeatNumber(show.getId(), seat).orElseThrow();
            bookingSeatRepository.save(BookingSeat.builder().booking(booking).showSeat(seatEntity).build());
        }

        return new BookingResponse(booking.getId(), booking.getStatus().name(), subtotal, discount, total);
    }
}
