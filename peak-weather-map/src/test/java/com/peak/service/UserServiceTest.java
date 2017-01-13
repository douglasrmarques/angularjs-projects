package com.peak.service;

import com.peak.domain.City;
import com.peak.domain.User;
import com.peak.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for user service
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    private User user;

    @Before
    public void setUp(){
        user = new User("001002", "douglasbrca", "douglasbr.ca@gmail.com");
        userRepository.save(user);
    }

    @Test
    public void validateNewUserIsNotNullTest(){
        User user = new User("000300408", "User UnitTest", "unitest@unitest.com.br");
        userRepository.save(user);
        Assert.assertNotNull(user.getUserId());
        Assert.assertNotNull(userRepository.findOne(user.getUserId()));
    }

    @Test
    public void testCityInsertAndRemoveToUser(){
        City city1 = new City("Rio de Janeiro, RJ");
        City city2 = new City("Curitiba, PR");
        City city3 = new City("Sao Paulo, SP");
        City city4 = new City("North York, ON");
        City city5 = new City("New York, NY");

        List<City> cityList = new ArrayList<City>();
        cityList.add(city1);
        cityList.add(city2);

        user.setCityList(cityList);
        userRepository.save(user);
        Assert.assertEquals(2, user.getCityList().size());

        //Removing a city
        cityList.remove(1);
        user.setCityList(cityList);
        userRepository.save(user);
        Assert.assertEquals(1, user.getCityList().size());

        //Adding some more
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);
        user.setCityList(cityList);
        userRepository.save(user);
        Assert.assertEquals(4, user.getCityList().size());
    }
}
