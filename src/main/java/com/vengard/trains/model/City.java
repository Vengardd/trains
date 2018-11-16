package com.vengard.trains.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedList;
import java.util.List;

public class City {

    private String name;
    @JsonIgnore
    private List<City> adjacentyList = new LinkedList<>();
    @JsonIgnore
    private Integer distance = Integer.MAX_VALUE;
    @JsonIgnore
    private List<City> shortestPath = new LinkedList<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getAdjacentyList() {
        return adjacentyList;
    }

    public void setAdjacentyList(List<City> adjacentyList) {
        this.adjacentyList = adjacentyList;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<City> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<City> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString() {
        return "City{" +
//                "name='" + name + '\'' +
                '}';
    }
}
