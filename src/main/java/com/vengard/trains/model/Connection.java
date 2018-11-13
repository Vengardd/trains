package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;

public class Connection {

    private List<Train> routes = new ArrayList<>();
    private int distance;

    public Connection() {
    }

    public Connection(List<Train> routes, int distance) {
        this.routes = routes;
        this.distance = distance;
    }

    public List<Train> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Train> routes) {
        this.routes = routes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "routes=" + routes +
                ", distance=" + distance +
                '}';
    }
}
