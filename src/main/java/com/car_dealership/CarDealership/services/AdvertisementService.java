package com.car_dealership.CarDealership.services;

import com.car_dealership.CarDealership.models.Advertisement;
import com.car_dealership.CarDealership.repositories.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;

    public Iterable<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Advertisement updateAdvertisement(Advertisement advertisement, Advertisement updatedAdvertisement) {
        BeanUtils.copyProperties(updatedAdvertisement, advertisement, "id");
        return advertisementRepository.save(advertisement);
    }

    public Advertisement saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        return advertisement;
    }

    public void deleteAdvertisement(Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }
}
