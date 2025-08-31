/**
 * 
 */
package com.xyz.booking.dto;

/**
 * @author PrasadBonam
 *
 */

import java.util.List;

public record BrowseResponse(String city, String movieTitle, String date, List<TheatreShows> theatres) {
    public record TheatreShows(String theatreName, List<ShowSlot> shows) {}
    public record ShowSlot(Long showId, String time, int availableSeats, int priceCents) {}
}
