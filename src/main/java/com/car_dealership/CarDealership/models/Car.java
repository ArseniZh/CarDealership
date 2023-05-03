package com.car_dealership.CarDealership.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    @Column (name = "brand")
    private String brand;
    @Column (name = "model")
    private String model;
    @Column (name = "year")
    private int year;
    @Column (name = "mileage")
    private long mileage;

    @OneToOne (mappedBy = "car", cascade = CascadeType.ALL)
    private Advertisement advertisement;

    public Car() {
    }
}
