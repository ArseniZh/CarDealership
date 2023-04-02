package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.repositories.AdvertisementRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainPageController {
    private AdvertisementRepository advertisementRepository;
    @GetMapping("/advertisements")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/advertisement/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") Advertisement advertisement) {
        return advertisement;
    }

}
