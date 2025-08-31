/**
 * 
 */
package com.xyz.movie.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.movie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
