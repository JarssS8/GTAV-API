package com.jars.gtavapi.controller;

import com.jars.gtavapi.dto.CarOnSaleDto;
import com.jars.gtavapi.service.CarOnSaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/api/cars-on-sale")
@Tag(name = "Car On Sale Controller", description = "API for Larrys on Sale Cars")
public class CarOnSaleController {

    @Autowired
    CarOnSaleService carOnSaleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    @Operation(summary = "Get All On Sale Cars", description = "Get all cars on sale from GTA V")
    public ResponseEntity<List<CarOnSaleDto>> getAllOnSaleCars() {
        return ok(carOnSaleService.getAllCarsOnSale());
    }
}
