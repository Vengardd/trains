package com.vengard.trains.repository;

import com.vengard.trains.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository {

    City addCity(City city);
    Optional<City> findCityByCity(City city);
    Optional<City> findCityByName(String name);
    List<City> findAll();
    void set(int index, City element);
}
