package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRestRepository cityRestRepository;

    public Iterable<City> getAllCities(){
        return cityRestRepository.findAll();
    }
    public City saveCity(City city){
        return cityRestRepository.save(city);
    }
    public Optional<City> getCityById(Long id){
        return cityRestRepository.findById(id);
    }

    public Optional<City> getCityByName(String cityName){
        return cityRestRepository.getCityByCityName(cityName);
    }


}
