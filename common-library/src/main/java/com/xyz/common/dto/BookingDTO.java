/**
 * 
 */
package com.xyz.common.dto;

/**
 * @author PrasadBonam
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private ShowDTO show;
    private List<String> seatNumbers;
    private double totalPrice;
}

