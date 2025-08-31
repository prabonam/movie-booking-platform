package com.xyz.booking.controller;


import com.xyz.booking.dto.BookingRequest;
import com.xyz.booking.dto.BookingResponse;
import com.xyz.booking.dto.BrowseRequest;
import com.xyz.booking.dto.BrowseResponse;
import com.xyz.booking.service.BookingService;
import com.xyz.booking.service.BrowseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final BrowseService browseService;

    @PostMapping("/bookings")
    public BookingResponse book(@RequestBody @Valid BookingRequest request) {
        return bookingService.book(request);
    }

    @GetMapping("/browse")
    public BrowseResponse browse(@RequestParam String city,
                                 @RequestParam String movieTitle,
                                 @RequestParam String date) {
        var req = new BrowseRequest(city, movieTitle, java.time.LocalDate.parse(date));
        return browseService.browse(req);
    }
}
