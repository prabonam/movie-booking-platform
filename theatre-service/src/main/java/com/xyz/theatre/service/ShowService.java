/**
 * 
 */
package com.xyz.theatre.service;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.theatre.entity.Show;
import com.xyz.theatre.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> findShows(String movieName, String city, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return showRepository.findByMovieNameAndTheatre_CityAndShowTimeBetween(movieName, city, start, end);
    }
}
