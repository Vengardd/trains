package com.vengard.trains.service;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {

    @Autowired
    private TrainService trainService;

    public Connection createConnection(String start, String destination) {
        trainService.findCityInTrains(start).orElseThrow(CityNotFoundException::new);
        trainService.findCityInTrains(destination).orElseThrow(CityNotFoundException::new);
        return new Connection();
    }

}
