package com.peak.repository;

import com.peak.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * City Repository
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    /**
     * It retrieves a city as its city name
     * @param cityName
     * @return City
     */
    City findByCityName(String cityName);

}
