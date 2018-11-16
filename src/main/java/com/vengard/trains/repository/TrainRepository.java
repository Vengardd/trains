package com.vengard.trains.repository;

import com.vengard.trains.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainRepository {

    Train addTrain(Train train);
    Optional<Train> findTrain(Train train);
    List<Train> findAll();
}
