package com.vengard.trains.repository;

import com.vengard.trains.model.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("CityRepositoryInMemory")
public class CityRepositoryInMemory implements CityRepository {

    private List<City> list = new ArrayList<>();

    @Override
    public City addCity(City city) {
        list.add(city);
        return city;
    }

    @Override
    public Optional<City> findCityByCity(City city) {
        int i = list.indexOf(city);
        if(i >= 0)
            return Optional.of(list.get(i));
        return Optional.empty();
    }

    @Override
    public Optional<City> findCityByName(String name) {
        City city = new City(name);
        return findCityByCity(city);
    }

    @Override
    public List<City> findAll() {
        return list;
    }

    @Override
    public void set(int index, City element) {
        list.set(index, element);
    }
}
