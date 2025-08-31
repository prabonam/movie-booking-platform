/**
 * 
 */
package com.xyz.booking.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

