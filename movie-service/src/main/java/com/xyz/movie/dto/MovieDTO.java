package com.xyz.movie.dto;

public record MovieDTO(
        Long id,
        String title,
        String genre,
        String language,
        String city
) {}
