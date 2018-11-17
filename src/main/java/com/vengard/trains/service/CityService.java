package com.vengard.trains.service;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.model.City;
import com.vengard.trains.model.Train;
import com.vengard.trains.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findCityByName(City city) {
        return cityRepository.findCity(city).orElseThrow(CityNotFoundException::new);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        if (cityRepository.findCity(city).isPresent())
            return null;
        return cityRepository.addCity(city);
    }

    public void addCitiesFromTrain(Train train) {
        City start = addCity(train.getTrain().get(0));
        City dest = addCity(train.getTrain().get(1));
        if (!start.equals(null)) {
            if (!dest.equals(null))
                start.getAdjacentyList().add(dest);
            else
                start.getAdjacentyList().add(findCityByName(dest));
        } else {
            start = findCityByName(start);
            try {
                dest = findCityByName(dest);
                if(!start.getAdjacentyList().contains(dest))
                    start.getAdjacentyList().add(dest);
            } catch (CityNotFoundException e) {
                start.getAdjacentyList().add(dest);
            }
        }
    }
}
