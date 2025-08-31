/**
 * 
 */
package com.xyz.booking.entity;

/**
 * @author PrasadBonam
 *
 */
 
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Booking booking;

    @ManyToOne(optional = false)
    private ShowSeat showSeat;
}

