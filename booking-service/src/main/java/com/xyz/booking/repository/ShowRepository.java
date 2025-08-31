/**
 * 
 */
package com.xyz.booking.repository;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.booking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieTitleIgnoreCaseAndShowTimeBetween(String movieTitle, LocalDateTime start, LocalDateTime end);
}

