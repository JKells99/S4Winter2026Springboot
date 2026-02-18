package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    public Iterable<City> getAllCities(){
        return cityService.getAllCities();
    }
    public City createCity(City city){
        return cityService.saveCity(city);
    }
    public Optional<City> getCityById(Long id){
        return cityService.getCityById(id);
    }
    public Optional<City> getCityByName(String cityName){
        return cityService.getCityByName(cityName);
    }


}
