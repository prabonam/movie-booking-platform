/**
 * 
 */
package com.xyz.theatre.dto;

/**
 * @author PrasadBonam
 *
 */

 
import lombok.Data;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDTO {
    private Long id;
    private String name;
    private String location;
}
