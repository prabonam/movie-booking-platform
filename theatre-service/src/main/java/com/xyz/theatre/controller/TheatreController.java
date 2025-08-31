/**
 * 
 */

/**
 * @author PrasadBonam
 *
 */
package com.xyz.theatre.controller;

import com.xyz.theatre.entity.Show;
import com.xyz.theatre.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    private final ShowService showService;

    public TheatreController(ShowService showService) {
        this.showService = showService;
    }

    // Browse theatres running a movie in a given city and date
    @GetMapping("/shows")
    public List<Show> getShows(
            @RequestParam String movieName,
            @RequestParam String city,
            @RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return showService.findShows(movieName, city, parsedDate);
    }
}
