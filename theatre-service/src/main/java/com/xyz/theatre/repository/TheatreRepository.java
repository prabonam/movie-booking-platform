/**
 * 
 */
package com.xyz.theatre.repository;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.theatre.entity.Show;
import com.xyz.theatre.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findByCity(String city);
}

 
