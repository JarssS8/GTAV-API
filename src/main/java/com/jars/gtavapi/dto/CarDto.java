package com.jars.gtavapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CarDto {
    private String spawnName;
    private String displayName;
    private String category;
    private String image;
    private int price;
}
