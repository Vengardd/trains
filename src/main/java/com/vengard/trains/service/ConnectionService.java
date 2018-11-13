package com.vengard.trains.service;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {

    @Autowired
    private TrainService trainService;

    @Autowired
    private GraphService graphService;

    public Connection createConnection(String start, String destination) {
        City startCity= new City(trainService.findCityInTrains(start).orElseThrow(CityNotFoundException::new));
        City destCity = new City(trainService.findCityInTrains(destination).orElseThrow(CityNotFoundException::new));
        return graphService.findShortestPath(startCity, destCity);
    }

}
