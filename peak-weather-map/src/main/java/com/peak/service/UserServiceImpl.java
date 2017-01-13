package com.peak.service;

import com.peak.domain.City;
import com.peak.domain.User;
import com.peak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * User Services
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CityService cityService;

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User createFacebookUser(Principal principal) {
        User user = userRepository.findByUserFacebookId(principal.getName());

        if(user == null){
            user = new User(principal.getName(), "undefined", "undefined");
            user.setCityList(new ArrayList<City>());
            return userRepository.save(user);
        }

        return user;
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.exists(user.getUserId())){
            userRepository.save(user);
        }

        Hashtable<String, Integer> has = new Hashtable<String, Integer>();

        for(Integer ints : has.values()){

        }

        return user;
    }

    @Override
    public Iterable<City> addCityToFacebookUser(String cityName) {
        String userFacebookId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserFacebookId(userFacebookId);

        // If the city does not exist, it's going to create a new
        City city = cityService.findByCityName(cityName);

        if(city == null){
            city = new City(cityName);
        }

        if(!user.getCityList().contains(city)){
            cityService.createCity(city);

            // Update the user cities list
            user.getCityList().add(city);
            userRepository.save(user);
        }

        return user.getCityList();
    }

    @Override
    public Iterable<City> getCityUserList() {
        String userFacebookId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserFacebookId(userFacebookId).getCityList();
    }

    @Override
    public Iterable<City> removeCityToFacebookUser(String cityName) {
        String userFacebookId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserFacebookId(userFacebookId);

        City city = cityService.findByCityName(cityName);

        user.getCityList().remove(city);
        userRepository.save(user);

        return user.getCityList();
    }
}
