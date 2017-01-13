package com.peak.controller;

import com.peak.domain.City;
import com.peak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Application Controller
 */
@RestController
public class PeakWeatherMainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Principal user(Principal principal){
        userService.createFacebookUser(principal);
        return principal;
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public Iterable<City> addCityToFacebookUser(@RequestBody String cityName){
        return userService.addCityToFacebookUser(cityName);
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public Iterable<City> getCityUserList(){
        return userService.getCityUserList();
    }

    @RequestMapping(value = "/city/delete")
    public Iterable<City> removeCityToFacebookUser(@RequestBody String cityName){
        return userService.removeCityToFacebookUser(cityName);
    }
}
