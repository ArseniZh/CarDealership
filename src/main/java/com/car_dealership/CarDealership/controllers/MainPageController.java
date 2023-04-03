package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.services.AdvertisementService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MainPageController {
    private AdvertisementService advertisementService;
    @GetMapping("/advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") Advertisement advertisement) {
        final Logger log = LoggerFactory.getLogger(MainPageController.class);
        log.info(String.valueOf(advertisement));
        return advertisement;
    }

    @PostMapping("/advertisements")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        return advertisementService.saveAdvertisement(advertisement);
    }

    @PutMapping("/advertisements/{id}")
    public Advertisement updateAdvertisement(@PathVariable("id") Advertisement advertisement, @RequestBody Advertisement updatedAdvertisement) {
        return advertisementService.updateAdvertisement(advertisement, updatedAdvertisement);
    }

    @DeleteMapping("/advertisements/{id}")
    public void deleteAdvertisement(@PathVariable("id") Advertisement advertisement) {
        advertisementService.deleteAdvertisement(advertisement);
    }
}
