package com.vengard.trains.model;

import com.vengard.trains.exception.PathDoesntExistException;

import java.util.*;

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

    public Connection getAllShortestPathsAndDistance(City start, City destination) {
        List<Train> result = new ArrayList<>();
        LinkedList<City> settledCities = new LinkedList<>();
        LinkedList<City> unsettledCities = new LinkedList<>();
        boolean foundedDestination = false;
        int distance = 0;

        unsettledCities.add(start);

        setDistanceInStartCity(trainConnections, start);

        while (!unsettledCities.isEmpty()) {
            City currentCity = unsettledCities.getFirst();
            unsettledCities.remove(unsettledCities.getFirst());
            for (City c : currentCity.getAdjacentyList()) {
                if (!settledCities.contains(c)) {
                    c.setDistance(currentCity.getDistance() + 1);
                    currentCity.getShortestPath().forEach(cc -> c.getShortestPath().add(cc));
                    c.getShortestPath().add(currentCity);
                    if (!foundedDestination)
                        unsettledCities.add(c);
                }
                if (c.getName().equals(destination.getName()))
                    foundedDestination = true;
            }
            settledCities.add(currentCity);
        }

        for (City c :
                settledCities) {
            for(City cc:
                    c.getAdjacentyList())
                if(cc.getName().equals(destination.getName())) {
                    Train train = new Train(c.getShortestPath());
                    train.getTrain().add(c);
                    train.getTrain().add(destination);
                    result.add(train);
                }
        }
        if(result.isEmpty())
            throw new PathDoesntExistException();
        distance = result.get(0).getTrain().get(result.get(0).getTrain().size()-1).getDistance();
        return new Connection(result, distance);
    }

    private void setDistanceInStartCity(Map<City, List<City>> trainConnections, City start) {
        start.setDistance(0);
        List<City> list = trainConnections.get(start);
        trainConnections.remove(start);
        trainConnections.put(start, list);
    }
}
