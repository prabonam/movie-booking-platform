package com.xyz.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	private Long id;
	private String title;
	private String language;
	private String genre;
	private int duration; // in minutes
}
