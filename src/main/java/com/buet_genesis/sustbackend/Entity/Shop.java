package com.buet_genesis.sustbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="shop")
public class Shop {
    @Id
    @GeneratedValue
    private Integer shop_id;
    @Column(name="shop_name",columnDefinition = "TEXT")
    private String shop_name;
    @Column(name="email",columnDefinition = "TEXT")
    private String email;
    @Column(name="address",columnDefinition = "TEXT")
    private String address;
    @Column(name="lat")
    private Double lat;
    @Column(name="lng")
    private Double lng;

    @Column(name="color")
    private String color;

    @Column(name="picture",columnDefinition = "TEXT")
    private String picture;

    @Column(name="cover_pic",columnDefinition = "TEXT")
    private String cover_pic;

    public Shop(){}

    public Shop(Integer shop_id, String shop_name, String email, String address, Double lat, Double lng, String color, String picture, String cover_pic) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.email = email;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.color = color;
        this.picture = picture;
        this.cover_pic = cover_pic;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }
}

