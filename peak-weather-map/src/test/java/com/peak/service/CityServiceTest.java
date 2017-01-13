package com.peak.service;

import com.peak.domain.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit test for city
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void testCityInsertAndRetrieve(){
        City city = new City("Vancouver, BC");
        cityService.createCity(city);
        Assert.assertEquals(city.getCityId(), cityService.findByCityName("Vancouver, BC").getCityId());
    }

    @Test
    public void testUpdateCity(){
        City city = new City("Vancouver, BC");
        cityService.createCity(city);

        Assert.assertEquals("Vancouver, BC", cityService.findCityById(city.getCityId()).getCityName());

        city.setCityName("Toronto, ON");
        cityService.updateCity(city);

        Assert.assertEquals("Toronto, ON", cityService.findCityById(city.getCityId()).getCityName());
    }
}
