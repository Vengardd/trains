package com.vengard.trains.service;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.model.City;
import com.vengard.trains.model.Train;
import com.vengard.trains.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findCityByCity(City city) {
        return cityRepository.findCityByCity(city).orElseThrow(CityNotFoundException::new);
    }

    public City findCityByCity(String name) {
        return cityRepository.findCityByName(name).orElseThrow(CityNotFoundException::new);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        if (cityRepository.findCityByCity(city).isPresent())
            return null;
        return cityRepository.addCity(city);
    }

    public void zeroShortestPaths() {
        findAll().forEach(c -> c.setShortestPath(new LinkedList<>()));
    }

    public void addCitiesFromTrain(Train train) {
        City start = addCity(train.getTrain().get(0));
        City dest = addCity(train.getTrain().get(1));
        if (start != null) {
            if (dest != null)
                start.getAdjacentyList().add(dest);
            else
                start.getAdjacentyList().add(findCityByCity(dest));
        } else {
            start = findCityByCity(train.getTrain().get(0));
            try {
                dest = findCityByCity(train.getTrain().get(1));
                if(!start.getAdjacentyList().contains(dest)) {
                    start.getAdjacentyList().add(dest);
                    cityRepository.set(cityRepository.findAll().indexOf(train.getTrain().get(0)), start);
                }
            } catch (CityNotFoundException e) {
                start.getAdjacentyList().add(dest);
            }
        }
    }
}
