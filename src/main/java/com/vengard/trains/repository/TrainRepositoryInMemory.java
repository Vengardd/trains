package com.vengard.trains.repository;

import com.vengard.trains.model.Train;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("TrainRepositoryInMemory")
public class TrainRepositoryInMemory implements TrainRepository {

    private List<Train> trainList = new ArrayList<>();

    @Override
    public Train addTrain(Train train) {
        trainList.add(train);
        return train;
    }

    @Override
    public Optional<Train> findTrain(Train train) {
        if(trainList.contains(train))
            return Optional.of(train);
        return Optional.empty();
    }

    @Override
    public Iterable<Train> findAll() {
        return trainList;
    }
}
