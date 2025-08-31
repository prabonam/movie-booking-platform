/**
 * 
 */
package com.xyz.movie.service;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.movie.dto.MovieDTO;
import com.xyz.movie.entity.Movie;
import com.xyz.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private MovieDTO mapToDTO(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre().getName(),
                movie.getLanguage().getName(),
                movie.getCity()
        );
    }

    @Override
    public List<MovieDTO> getMoviesByCity(String city) {
        return movieRepository.findByCityIgnoreCase(city)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<MovieDTO> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguage_NameIgnoreCase(language)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre_NameIgnoreCase(genre)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
}
