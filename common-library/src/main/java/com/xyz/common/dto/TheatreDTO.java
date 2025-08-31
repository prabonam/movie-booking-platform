package com.xyz.common.dto;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDTO {
    private Long id;
    private String name;
    private String city;
    private int totalScreens;
}
