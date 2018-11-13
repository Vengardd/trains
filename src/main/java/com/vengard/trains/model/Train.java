package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {

    private List<City> train = new ArrayList<>();

    public Train() {
    }

    public Train(List<City> train) {
        this.train = train;
    }

    public List<City> getTrain() {
        return train;
    }

    public void setTrain(List<City> train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Train{" +
                "train=" + train +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train1 = (Train) o;
        return Objects.equals(train, train1.train);
    }

    @Override
    public int hashCode() {
        return Objects.hash(train);
    }
}