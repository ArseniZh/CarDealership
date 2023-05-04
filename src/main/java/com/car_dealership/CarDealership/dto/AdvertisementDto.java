package com.car_dealership.CarDealership.dto;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.models.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertisementDto {
    private String author;
    private String city;
    private long price;
    private String description;
    private String brand;
    private String model;
    private int year;
    private long mileage;

    public static AdvertisementDto createDtoFromAdvertisement(Advertisement advertisement, Car car) {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setAuthor(advertisement.getAuthor());
        advertisementDto.setCity(advertisement.getCity());
        advertisementDto.setPrice(advertisement.getPrice());
        advertisementDto.setDescription(advertisement.getDescription());

        advertisementDto.setBrand(car.getBrand());
        advertisementDto.setModel(car.getModel());
        advertisementDto.setYear(car.getYear());
        advertisementDto.setMileage(car.getMileage());

        return advertisementDto;
    }

    public static Advertisement createAdvertisementFromDto(AdvertisementDto advertisementDto) {
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
        return advertisement;
    }
}
