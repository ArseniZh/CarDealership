package com.car_dealership.CarDealership.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Advertisement {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    @Column (name = "author")
    private String author;
    @Column (name = "city")
    private String city;
    @Column (name = "brand")
    private String brand;
    @Column (name = "model")
    private String model;
    @Column (name = "year")
    private int year;
    @Column (name = "mileage")
    private long mileage;
    @Column (name = "price")
    private long price;
    @Column (name = "description" , columnDefinition = "text")
    private String description;

    public Advertisement() {
    }

    public Long getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCity() {
        return this.city;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public long getMileage() {
        return this.mileage;
    }

    public long getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Advertisement)) return false;
        final Advertisement other = (Advertisement) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$author = this.getAuthor();
        final Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$brand = this.getBrand();
        final Object other$brand = other.getBrand();
        if (this$brand == null ? other$brand != null : !this$brand.equals(other$brand)) return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        if (this.getYear() != other.getYear()) return false;
        if (this.getMileage() != other.getMileage()) return false;
        if (this.getPrice() != other.getPrice()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Advertisement;
    }

    public String toString() {
        return "Advertisement(id=" + this.id + ", author=" + this.author + ", city=" + this.city +
                ", brand=" + this.brand + ", model=" + this.model + ", year=" + this.year +
                ", mileage=" + this.mileage + ", price=" + this.price + ", description=" + this.description + ")";
    }
}
