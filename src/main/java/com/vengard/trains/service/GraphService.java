package com.vengard.trains.service;

import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import com.vengard.trains.model.Graph;
import com.vengard.trains.model.Train;
import com.vengard.trains.service.algorithm.FindShortesPathAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GraphService {

    @Autowired
    private FindShortesPathAlgorithm findShortestPathAlgorithm;

    @Autowired
    private CityService cityService;

    private static Graph graph = new Graph();

    public Connection findShortestPath(String start, String destination) {
        setTrainConnectionsFromCities(cityService.findAll());
        return findShortestPathAlgorithm.findShortestPath(graph, cityService.findCityByCity(start), cityService.findCityByCity(destination));
    }
    public void setTrainConnectionsFromCities(List<City> cities) {
        Map<City, List<City>> trainConnections = new HashMap<>();
        cities.forEach(c -> trainConnections.put(c, c.getAdjacentyList()));
        graph.setTrainConnections(trainConnections);
    }

}
