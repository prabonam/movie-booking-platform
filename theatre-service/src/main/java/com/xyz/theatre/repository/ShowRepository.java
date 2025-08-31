/**
 * 
 */
package com.xyz.theatre.repository;

/**
 * @author PrasadBonam
 *
 */
package com.xyz.theatre.repository;

import com.xyz.theatre.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
