package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.services.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AdvertisementController {
    private AdvertisementService advertisementService;

    @GetMapping("/advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") Advertisement advertisement) {
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
