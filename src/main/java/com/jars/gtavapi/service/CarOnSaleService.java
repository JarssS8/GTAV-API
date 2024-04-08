package com.jars.gtavapi.service;

import com.jars.gtavapi.dto.CarDto;
import com.jars.gtavapi.dto.CarOnSaleDto;
import com.jars.gtavapi.entity.CarOnSale;
import com.jars.gtavapi.repository.CarOnSaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarOnSaleService {
    @Autowired
    CarOnSaleRepository carOnSaleRepository;

    @Autowired
    CarService carService;

    @Autowired
    ModelMapper modelMapper;

    @Cacheable(value = "carsOnSale")
    public List<CarOnSaleDto> getAllCarsOnSale() {
        List<CarOnSale> carsOnSale = carOnSaleRepository.findAll();
        List<CarOnSaleDto> carsOnSaleDto = carsOnSale.stream()
                .map(carOnSale -> modelMapper.map(carOnSale, CarOnSaleDto.class))
                .toList();
        carsOnSaleDto.forEach(carOnSaleDto -> {
            CarDto car = carService.getCarBySpawnName(carOnSaleDto.getSpawnName());
            if(car != null) {
                carOnSaleDto.setSellPrice((int) (car.getPrice()* 0.75));
                carOnSaleDto.setImage(car.getImage());
            }
        });
        return carsOnSaleDto;
    }

    public void deleteAllCars() {
        carOnSaleRepository.deleteAll();
    }

    public void saveCar(CarOnSale carOnSale) {
        carOnSaleRepository.save(carOnSale);
    }
}