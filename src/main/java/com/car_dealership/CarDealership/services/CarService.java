package com.car_dealership.CarDealership.services;

import com.car_dealership.CarDealership.models.Car;
import com.car_dealership.CarDealership.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    public Car updateCar(Car car, Car updatedCar) {
        BeanUtils.copyProperties(updatedCar, car, "id");
        return carRepository.save(car);
    }
}
