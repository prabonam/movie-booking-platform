/**
 * 
 */
package com.xyz.booking.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.booking.entity.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {
}

