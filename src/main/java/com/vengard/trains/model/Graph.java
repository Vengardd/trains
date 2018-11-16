package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<City, List<City>> trainConnections = new HashMap<>();

    public void setTrainConnectionsFromTrains(List<Train> trains) {
        trains.forEach(t -> {
            City start = t.getTrain().get(0);
            City dest = t.getTrain().get(1);
            if (!trainConnections.containsKey(start)) { //if this city doesnt exist, add it
                List<City> list = new ArrayList<>();
                list.add(dest);
                trainConnections.put(start, list);
            } else if (!trainConnections.get(start).contains(dest)) //if this road doesnt exists
                trainConnections.get(start).add(dest);
        });
    }

    public Map<City, List<City>> getTrainConnections() {
        return trainConnections;
    }
    public void setTrainConnections(Map<City, List<City>> trainConnections) {
        this.trainConnections = trainConnections;
    }
}
