package com.peak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.Filter;

/**
 * Runner spring boot application class
 */
@SpringBootApplication
public class PeakWeatherApplication {

    public static void main(String[] args){
        SpringApplication.run(PeakWeatherApplication.class, args);
    }
}
