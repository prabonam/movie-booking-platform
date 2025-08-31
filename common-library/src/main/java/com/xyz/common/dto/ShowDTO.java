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

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {
    private Long id;
    private MovieDTO movie;
    private TheatreDTO theatre;
    private LocalDateTime showTime;
    private double price;
}
