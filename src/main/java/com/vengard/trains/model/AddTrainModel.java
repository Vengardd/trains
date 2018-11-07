package com.vengard.trains.model;

public class AddTrainModel {

    private Train train;

    public AddTrainModel() {
    }

    public AddTrainModel(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
