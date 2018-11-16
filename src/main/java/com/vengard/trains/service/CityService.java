package com.vengard.trains.service;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.model.City;
import com.vengard.trains.repository.CityRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepositoryInMemory cityRepositoryInMemory;

    public City findCityByName(City city) {
        return cityRepositoryInMemory.findCity(city).orElseThrow(CityNotFoundException::new);
    }

    public List<City> findAll() {
        return cityRepositoryInMemory.findAll();
    }
}
