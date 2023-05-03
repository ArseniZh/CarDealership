package com.car_dealership.CarDealership.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    @Column (name = "author")
    private String author;
    @Column (name = "city")
    private String city;
    @Column (name = "price")
    private long price;
    @Column (name = "description" , columnDefinition = "text")
    private String description;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User user;


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
        if (this.getPrice() != other.getPrice()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$car = this.getCar();
        final Object other$car = other.getCar();
        if (this$car == null ? other$car != null : !this$car.equals(other$car)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $author = this.getAuthor();
        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final long $price = this.getPrice();
        result = result * PRIME + (int) ($price >>> 32 ^ $price);
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $car = this.getCar();
        result = result * PRIME + ($car == null ? 43 : $car.hashCode());
        return result;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Advertisement;
    }

    public String toString() {
        return "Advertisement(id=" + this.id + ", author=" + this.author + ", city=" + this.city +
                "price=" + this.price + ", description=" + this.description + ")";
    }
}