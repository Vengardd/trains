package com.vengard.trains.repository;

import com.vengard.trains.model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepositoryInMemory implements CityRepository {

    private static List<City> list = new ArrayList<>();

    @Override
    public City addCity(City city) {
        list.add(city);
        return city;
    }

    @Override
    public Optional<City> findCity(City city) {
        if(list.contains(city))
            return Optional.of(city);
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        return list;
    }
}
