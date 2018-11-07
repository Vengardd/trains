package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {

    private List<String> train = new ArrayList<>();

    public Train() {
    }

    public Train(List<String> train) {
        this.train = train;
    }

    public List<String> getTrain() {
        return train;
    }

    public void setTrain(List<String> train) {
        this.train = train;
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
