package com.vengard.trains.repository;

import com.vengard.trains.model.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    City addCity(City city);
    Optional<City> findCity(City city);
    List<City> findAll();
}
