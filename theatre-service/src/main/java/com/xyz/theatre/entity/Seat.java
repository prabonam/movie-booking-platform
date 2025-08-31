/**
 * 
 */
package com.xyz.theatre.entity;

/**
 * @author PrasadBonam
 *
 */
 
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;
    private boolean booked;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}

