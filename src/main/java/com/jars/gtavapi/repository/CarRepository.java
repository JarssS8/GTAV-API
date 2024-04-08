package com.jars.gtavapi.repository;

import com.jars.gtavapi.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
