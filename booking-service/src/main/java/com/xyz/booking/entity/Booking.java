package com.xyz.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @ManyToOne(optional = false)
    private Show show;

    private int seatCount;
    private int subtotalCents;
    private int discountCents;
    private int totalCents;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private OffsetDateTime createdAt;
}
