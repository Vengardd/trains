package com.vengard.trains.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<City, List<City>> trainConnections = new HashMap<>();

    public Map<City, List<City>> getTrainConnections() {
        return trainConnections;
    }

    public void setTrainConnections(Map<City, List<City>> trainConnections) {
        this.trainConnections = trainConnections;
    }
}
