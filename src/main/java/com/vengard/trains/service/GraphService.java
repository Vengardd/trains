package com.vengard.trains.service;

import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import com.vengard.trains.model.Graph;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    private Graph graph = new Graph();

    public Connection findShortestPath(City start, City destination) {
        return graph.getAllShortestPathsAndDistance(start, destination);
    }

}
