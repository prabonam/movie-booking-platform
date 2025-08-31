/**
 * 
 */
package com.xyz.theatre.dto;

/**
 * @author PrasadBonam
 *
 */
 
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDTO {
    private Long id;
    private String seatNumber;
    private boolean booked;
    private Long showId;
}
