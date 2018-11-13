package com.vengard.trains.model;

import com.vengard.trains.exception.PathDoesntExistException;

import java.util.*;

public class Graph {

    private Map<City, List<City>> trainConnections = new HashMap<>();

    public static void main(String[] args) {
        Graph graph = new Graph();

        City krakow = new City("krakow");
        City wawa = new City("wawa");
        City gdansk = new City("gdansk");
        City wroclaw = new City("wroclaw");

        City poznan = new City("poznan");
        City zakopane = new City("zakopane");

        City przasnysz = new City("przasnysz");
        City lanieta = new City("lanieta");


        List<City> l1 = new ArrayList<>();
        l1.add(krakow);
        l1.add(wawa);
        krakow.getAdjacentyList().add(wawa);
        List<City> l2 = new ArrayList<>();
        l2.add(wawa);
        l2.add(gdansk);
        wawa.getAdjacentyList().add(gdansk);
        List<City> l3 = new ArrayList<>();
        l3.add(gdansk);
        l3.add(wroclaw);
        gdansk.getAdjacentyList().add(wroclaw);

        List<City> l4 = new ArrayList<>();
        l4.add(krakow);
        l4.add(poznan);
        krakow.getAdjacentyList().add(poznan);
        List<City> l5 = new ArrayList<>();
        l5.add(poznan);
        l5.add(zakopane);
        poznan.getAdjacentyList().add(zakopane);
        List<City> l6 = new ArrayList<>();
        l6.add(zakopane);
        l6.add(wroclaw);
        zakopane.getAdjacentyList().add(wroclaw);

        List<City> l7 = new ArrayList<>();
        l7.add(przasnysz);
        l7.add(lanieta);
        przasnysz.getAdjacentyList().add(lanieta);

        List<City> l8 = new ArrayList<>();
        l8.add(zakopane);
        l8.add(przasnysz);
        zakopane.getAdjacentyList().add(przasnysz);

        List<City> l9 = new ArrayList<>();
        l9.add(lanieta);
        l9.add(wroclaw);
        lanieta.getAdjacentyList().add(wroclaw);



        Train t1 = new Train(l1);
        Train t2 = new Train(l2);
        Train t3 = new Train(l3);
        Train t4 = new Train(l4);
        Train t5 = new Train(l5);
        Train t6 = new Train(l6);
        Train t7 = new Train(l7);
        Train t8 = new Train(l8);
        Train t9 = new Train(l9);


        List<Train> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);

        graph.setTrainConnectionsFromTrains(list);

        System.out.println(graph.getAllShortestPathsAndDistance(krakow, wroclaw));
    }

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
