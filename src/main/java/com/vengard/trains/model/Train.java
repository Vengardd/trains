package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;

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
}
