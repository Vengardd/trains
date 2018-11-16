package com.vengard.trains.service.algorithm;

import com.vengard.trains.exception.PathDoesntExistException;
import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import com.vengard.trains.model.Graph;
import com.vengard.trains.model.Train;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class FindShortestPathOwnBfs implements FindShortesPathAlgorithm {

    @Override
    public Connection findShortestPath(Graph graph, City start, City destination) {
        List<Train> result = new ArrayList<>();
        LinkedList<City> settledCities = new LinkedList<>();
        LinkedList<City> unsettledCities = new LinkedList<>();
        boolean foundedDestination = false;
        int distance = 0;

        unsettledCities.add(start);

        graph.setTrainConnections(setDistanceInStartCity(graph.getTrainConnections(), start));

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
            for (City cc :
                    c.getAdjacentyList())
                if (cc.getName().equals(destination.getName())) {
                    Train train = new Train(c.getShortestPath());
                    train.getTrain().add(c);
                    train.getTrain().add(destination);
                    result.add(train);
                }
        }
        if (result.isEmpty())
            throw new PathDoesntExistException();
        distance = result.get(0).getTrain().get(result.get(0).getTrain().size() - 1).getDistance();
        return new Connection(result, distance);
    }

    private Map<City, List<City>> setDistanceInStartCity(Map<City, List<City>> trainConnections, City start) {
        start.setDistance(0);
        List<City> list = trainConnections.get(start);
        trainConnections.remove(start);
        trainConnections.put(start, list);
        return trainConnections;
    }
}
