/**
 * 
 */
package com.xyz.booking.dto;

/**
 * @author PrasadBonam
 *
 */

import java.time.LocalDate;
public record BrowseRequest(String city, String movieTitle, LocalDate date) {}
