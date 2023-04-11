package com.car_dealership.CarDealership.repositories;

import com.car_dealership.CarDealership.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName (String name);
}
