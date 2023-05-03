package com.car_dealership.CarDealership.services;

import com.car_dealership.CarDealership.dto.AdvertisementDto;
import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.models.Car;
import com.car_dealership.CarDealership.repositories.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdvertisementService {
    private AdvertisementRepository advertisementRepository;
    private CarService carService;

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Advertisement updateAdvertisement(Advertisement advertisement, AdvertisementDto updatedAdvertisement) {
        advertisement.setAuthor(updatedAdvertisement.getAuthor());
        advertisement.setCity(updatedAdvertisement.getCity());
        advertisement.setPrice(updatedAdvertisement.getPrice());
        advertisement.setDescription(updatedAdvertisement.getDescription());

        Car updatedCar = new Car();
        updatedCar.setBrand(updatedAdvertisement.getBrand());
        updatedCar.setModel(updatedAdvertisement.getModel());
        updatedCar.setYear(updatedAdvertisement.getYear());
        updatedCar.setMileage(updatedAdvertisement.getMileage());

        carService.updateCar(advertisement.getCar(), updatedCar);
        return advertisementRepository.save(advertisement);
    }

    public Advertisement saveAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setAuthor(advertisementDto.getAuthor());
        advertisement.setCity(advertisementDto.getCity());
        advertisement.setPrice(advertisementDto.getPrice());
        advertisement.setDescription(advertisementDto.getDescription());

        Car car = new Car();
        car.setBrand(advertisementDto.getBrand());
        car.setModel(advertisementDto.getModel());
        car.setYear(advertisementDto.getYear());
        car.setMileage(advertisementDto.getMileage());

        advertisement.setCar(car);
        car.setAdvertisement(advertisement);

        carService.addCar(car);
        advertisementRepository.save(advertisement);
        return advertisement;
    }

    public void deleteAdvertisement(Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }
}
