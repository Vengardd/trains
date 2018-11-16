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

    private static Graph graph = new Graph();

    public Connection findShortestPath(City start, City destination) {

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

        List<City> l10 = new ArrayList<>();
        l10.add(wroclaw);
        l10.add(krakow);
        wroclaw.getAdjacentyList().add(krakow);

        Train t1 = new Train(l1);
        Train t2 = new Train(l2);
        Train t3 = new Train(l3);
        Train t4 = new Train(l4);
        Train t5 = new Train(l5);
        Train t6 = new Train(l6);
        Train t7 = new Train(l7);
        Train t8 = new Train(l8);
        Train t9 = new Train(l9);
        Train t10 = new Train(l10);


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
        list.add(t10);

        setTrainConnectionsFromTrains(list);
        return findShortestPathAlgorithm.findShortestPath(graph, krakow, wroclaw);
    }


    public static void setTrainConnectionsFromTrains(List<Train> trains) {
        Map<City, List<City>> trainConnections = new HashMap<>();
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
        graph.setTrainConnections(trainConnections);
    }


}
