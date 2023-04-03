package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.repositories.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") Advertisement advertisement) {
        final Logger log = LoggerFactory.getLogger(MainPageController.class);
        log.info(String.valueOf(advertisement));
        return advertisement;
    }

    @PostMapping("/advertisements")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @PutMapping("/advertisements/{id}")
    public Advertisement updateAdvertisement(@PathVariable("id") Advertisement advertisement, @RequestBody Advertisement updatedAdvertisement) {
        BeanUtils.copyProperties(updatedAdvertisement, advertisement, "id");
        return advertisementRepository.save(advertisement);
    }

    @DeleteMapping("/advertisements/{id}")
    public void deleteAdvertisement(@PathVariable("id") Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }
}
