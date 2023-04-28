package com.car_dealership.CarDealership.repositories;

import com.car_dealership.CarDealership.models.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
