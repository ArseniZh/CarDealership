package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.repositories.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MainPageController {
    private final AdvertisementRepository advertisementRepository;
    @GetMapping("/advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    @GetMapping("/advertisement/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") Advertisement advertisement) {
        return advertisement;
    }

    @PostMapping
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @PutMapping("/advertisement/{id}")
    public Advertisement updateAdvertisement(@PathVariable("id") Advertisement advertisement, @RequestBody Advertisement updatedAdvertisement) {
        BeanUtils.copyProperties(updatedAdvertisement, advertisement, "id");
        return advertisementRepository.save(advertisement);
    }

    @DeleteMapping("/advertisement/{id}")
    public void deleteAdvertisement(@PathVariable("id") Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }
}
