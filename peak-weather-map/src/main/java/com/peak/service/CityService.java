package com.peak.service;

import com.peak.domain.City;

/**
 * City interface services
 */
public interface CityService {

    /**
     * It returns a city by Id
     * @param id
     * @return City
     */
    City findCityById(Long id);

    /**
     * It returns a city by cityName
     * @param cityName
     * @return City
     */
    City findByCityName(String cityName);

    /**
     * Creates and returns a city object
     * @param city
     * @return City
     */
    City createCity(City city);

    /**
     * Return all cities from database
     * @return Iterable
     */
    Iterable<City> findAll();

    /**
     * Update a city
     * @param city
     * @return City
     */
    City updateCity(City city);
}
