package com.vengard.trains.service;

import com.vengard.trains.exception.TrainExistingException;
import com.vengard.trains.model.Train;
import com.vengard.trains.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        if(trainRepository.findTrain(train).isPresent())
            throw new TrainExistingException();
        return trainRepository.addTrain(train);
    }

}
