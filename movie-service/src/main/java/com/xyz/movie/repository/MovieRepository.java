package com.xyz.movie.repository;

import com.xyz.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByCityIgnoreCase(String city);
    List<Movie> findByLanguage_NameIgnoreCase(String language);
    List<Movie> findByGenre_NameIgnoreCase(String genre);
}
