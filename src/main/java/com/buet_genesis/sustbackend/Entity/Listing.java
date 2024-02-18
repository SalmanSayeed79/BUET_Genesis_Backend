package com.buet_genesis.sustbackend.Entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name="listing")
public class Listing {
    @Id
    @GeneratedValue
    private Integer listing_id;
    @Column(name="shop_id")
    private Integer shop_id;
    @Column(name="title",columnDefinition = "TEXT")
    private String title;
    @Column(name="brand",columnDefinition = "TEXT")
    private String brand;
    @Column(name="type",columnDefinition = "TEXT")
    private String type;
    @Column(name="price")
    private Double price;

    @Column(name="images",columnDefinition = "TEXT")
    private String images;
    @Column(name="description",columnDefinition = "TEXT")
    private String description;

    public Listing(){}

    public Listing(Integer listing_id, Integer shop_id, String title, String brand, String type, Double price, String image, String description) {
        this.listing_id = listing_id;
        this.shop_id = shop_id;
        this.title = title;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.images = image;
        this.description = description;
    }

    public Integer getListing_id() {
        return listing_id;
    }

    public void setListing_id(Integer listing_id) {
        this.listing_id = listing_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

