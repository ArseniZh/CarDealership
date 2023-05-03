package com.car_dealership.CarDealership.repositories;

import com.car_dealership.CarDealership.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
