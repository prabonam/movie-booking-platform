/**
 * 
 */
package com.xyz.theatre.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author PrasadBonam
 *
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDTO {
	private Long id;
	private String movieName;
	private LocalDateTime showTime;
	private Long theatreId;
}
