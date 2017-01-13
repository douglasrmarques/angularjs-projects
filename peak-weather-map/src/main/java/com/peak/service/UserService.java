package com.peak.service;

import com.peak.domain.City;
import com.peak.domain.User;

import java.security.Principal;

/**
 * Interface with User's services
 */
public interface UserService {

    /**
     * It retrieves a user by its user id
     * @param userId
     * @return User
     */
    User findUserByUserId(Long userId);

    /**
     * It creates a new user into database
     * @param principal
     * @return User
     */
    User createFacebookUser(Principal principal);

    /**
     * It update a specific user into database
     * @param user
     * @return User
     */
    User updateUser(User user);

    /**
     * It adds a new city as favorite to user account
     * @param cityName
     */
    Iterable<City> addCityToFacebookUser(String cityName);

    /**
     * It removes the city from user's cities
     * @param cityName
     * @return Iterable
     */
    Iterable<City> removeCityToFacebookUser(String cityName);

    /**
     * It retrieves the list of cities of the user
     * @return Iterable
     */
    Iterable<City> getCityUserList();

}
