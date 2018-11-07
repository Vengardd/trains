package com.vengard.trains.service;

import com.vengard.trains.model.Train;
import com.vengard.trains.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    @Value("TrainRepositoryInMemory")
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return train;
    }

}
