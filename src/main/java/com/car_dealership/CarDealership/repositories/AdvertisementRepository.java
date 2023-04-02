package com.car_dealership.CarDealership.repositories;

import com.car_dealership.CarDealership.models.Advertisement;
import org.springframework.data.repository.CrudRepository;


public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
}
