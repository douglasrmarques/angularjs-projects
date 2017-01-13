package com.peak.domain;

import javax.persistence.*;

/**
 * City Entity Map
 */
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cityId;

    @Column(nullable = false, unique = true)
    private String cityName;

    public City(String cityName){
        this.cityName = cityName;
    }

    private City(){};

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City = City Name: " + cityName;
    }
}
