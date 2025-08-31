/**
 * 
 */
package com.xyz.movie.controller;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.movie.dto.MovieDTO;
import com.xyz.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/city/{city}")
    public List<MovieDTO> getMoviesByCity(@PathVariable String city) {
        return movieService.getMoviesByCity(city);
    }

    @GetMapping("/language/{language}")
    public List<MovieDTO> getMoviesByLanguage(@PathVariable String language) {
        return movieService.getMoviesByLanguage(language);
    }

    @GetMapping("/genre/{genre}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }
}
