package com.jars.gtavapi.service;

import com.jars.gtavapi.dto.CarDto;
import com.jars.gtavapi.entity.Car;
import com.jars.gtavapi.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    ModelMapper modelMapper;

    @Cacheable(value = "cars")
    public List<CarDto> getAllCars() {
        List<Car> cars= carRepository.findAll();
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .toList();
    }

    @Cacheable(value = "cars", key = "'GTAVCache'+#spawnName")
    public CarDto getCarBySpawnName(String spawnName) {
        return carRepository.findById(spawnName).map(car -> modelMapper.map(car, CarDto.class)).orElse(null);
    }

    @Cacheable(value = "cars", key = "'GTAVCache'+#displayName")
    public CarDto getCarByDisplayName(String displayName) {
        return carRepository.findAll().stream()
                .filter(car -> car.getDisplayName().equals(displayName))
                .map(car -> modelMapper.map(car, CarDto.class))
                .findFirst()
                .orElse(null);
    }

    @Cacheable(value = "cars", key = "'GTAVCache'+#category")
    public List<CarDto> getCarsByCategory(String category) {
        return carRepository.findAll().stream()
                .filter(car -> car.getCategory().equals(category))
                .map(car -> modelMapper.map(car, CarDto.class))
                .toList();
    }
}
