package com.jars.gtavapi.controller;

import com.jars.gtavapi.dto.CarDto;
import com.jars.gtavapi.service.CarService;
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
@RequestMapping("/api/cars")
@Tag(name = "Car Controller", description = "API for GTA V cars")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    @Operation(summary = "Get All Cars", description = "Get all cars from GTA V")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ok(carService.getAllCars());
    }

    @GetMapping("/{spawn_name}")
    @Operation(summary  = "Get Car by Spawn Name", description = "Get a car by its spawn name")
    public ResponseEntity<CarDto> getCarBySpawnName(String spawnName) {
        return ok(carService.getCarBySpawnName(spawnName));
    }

    @GetMapping("/displayName/{displayName}")
    @Operation(summary  = "Get Car by Display Name", description = "Get a car by its display name")
    public ResponseEntity<CarDto> getCarByDisplayName(String displayName) {
        return ok(carService.getCarByDisplayName(displayName));
    }

    @GetMapping("/category/{category}")
    @Operation(summary  = "Get Cars by Category", description = "Get all cars from a specific category")
    public ResponseEntity<List<CarDto>> getCarsByCategory(String category) {
        return ok(carService.getCarsByCategory(category));
    }
}
