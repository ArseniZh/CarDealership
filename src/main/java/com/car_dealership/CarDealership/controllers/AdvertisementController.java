package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.dto.AdvertisementDto;
import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.models.Car;
import com.car_dealership.CarDealership.services.AdvertisementService;
import com.car_dealership.CarDealership.services.CarService;
import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@AllArgsConstructor
public class AdvertisementController {
    private AdvertisementService advertisementService;
    private CarService carService;
    private UserService userService;

    @GetMapping("/advertisements")
    public List<AdvertisementDto> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        List<Car> cars = carService.getAllCars();

        return IntStream.range(0, advertisements.size())
                .mapToObj(i -> AdvertisementDto.createDtoFromAdvertisement(advertisements.get(i), cars.get(i)))
                .collect(Collectors.toList());
    }

    @GetMapping("/advertisements/{id}")
    public AdvertisementDto getAdvertisement(@PathVariable("id") Advertisement advertisement) {
        return AdvertisementDto.createDtoFromAdvertisement(advertisement, advertisement.getCar());
    }

    @PostMapping("/advertisements")
    public AdvertisementDto addAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        Advertisement advertisement = advertisementService.saveAdvertisement(advertisementDto);
        Car car = advertisement.getCar();
        return AdvertisementDto.createDtoFromAdvertisement(advertisement, car);
    }

    @PutMapping("/advertisements/{id}")
    public AdvertisementDto updateAdvertisement(@PathVariable("id") Advertisement advertisement, @RequestBody AdvertisementDto updatedAdvertisementDto)
            throws AccessDeniedException {
        if (userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getId() == advertisement.getUser().getId()) {
            Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(advertisement, updatedAdvertisementDto);
            Car car = updatedAdvertisement.getCar();
            return AdvertisementDto.createDtoFromAdvertisement(updatedAdvertisement, car);
        }
        throw new AccessDeniedException("access denied");
    }

    @DeleteMapping("/advertisements/{id}")
    public void deleteAdvertisement(@PathVariable("id") Advertisement advertisement)
            throws AccessDeniedException {
        if (userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getId() == advertisement.getUser().getId()) {
            advertisementService.deleteAdvertisement(advertisement);
            carService.deleteCar(advertisement.getCar());
        } else {
            throw new AccessDeniedException("access denied");
        }
    }
}
