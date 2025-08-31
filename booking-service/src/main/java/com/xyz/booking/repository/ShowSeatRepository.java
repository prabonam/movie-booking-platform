/**
 * 
 */
package com.xyz.booking.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.booking.entity.Show;
import com.xyz.booking.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findByShowAndBooked(Show show, boolean booked);
    Optional<ShowSeat> findByShow_IdAndSeatNumber(Long showId, String seatNumber);
}

