package com.jars.gtavapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CarOnSaleDto {
    private long id;
    private String spawnName;
    private String displayName;
    private int sellPrice;
    private String image;
}
