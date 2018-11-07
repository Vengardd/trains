package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;

public class AddTrainModel {

    private List<String> train = new ArrayList<>();

    public AddTrainModel() {
    }

    public List<String> getTrain() {
        return train;
    }

    public void setTrain(List<String> train) {
        this.train = train;
    }

    public AddTrainModel(List<String> train) {
        this.train = train;
    }
}
