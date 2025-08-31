package com.xyz.movie.service;

 
import com.xyz.movie.dto.MovieDTO;

import java.util.List;
import com.xyz.movie.dto.MovieDTO;

public interface MovieService {
    List<MovieDTO> getMoviesByCity(String city);
    List<MovieDTO> getMoviesByLanguage(String language);
    List<MovieDTO> getMoviesByGenre(String genre);
}
