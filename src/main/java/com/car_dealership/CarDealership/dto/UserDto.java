package com.car_dealership.CarDealership.dto;

import com.car_dealership.CarDealership.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

}
