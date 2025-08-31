/**
 * 
 */
package com.xyz.movie.repository;

/**
 * @author PrasadBonam
 *
 */
 
import com.xyz.movie.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {}
