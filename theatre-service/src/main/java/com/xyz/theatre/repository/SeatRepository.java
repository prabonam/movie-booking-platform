/**
 * 
 */
package com.xyz.theatre.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.theatre.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	
}


