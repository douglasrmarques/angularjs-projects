package com.peak.service;

import com.peak.domain.City;
import com.peak.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of city services
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    @Override
    public City createCity(City city) {
        if(findByCityName(city.getCityName()) == null){
            cityRepository.save(city);
        }

        return city;
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public City updateCity(City city) {
        return cityRepository.save(city);
    }
}
