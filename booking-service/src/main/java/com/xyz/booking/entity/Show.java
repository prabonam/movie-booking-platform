 
package com.xyz.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;
    private String theatreName;
    private LocalDateTime showTime;

    /**
     * Price in cents for one seat (avoid floating point in DB).
     */
    private int priceCents;
}
