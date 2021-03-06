package com.vengard.trains.service;

import com.vengard.trains.exception.SameConnectionException;
import com.vengard.trains.exception.TrainExistingException;
import com.vengard.trains.model.Train;
import com.vengard.trains.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CityService cityService;

    public Train addTrain(Train train) {
        if(trainRepository.findTrain(train).isPresent())
            throw new TrainExistingException();
        if(train.getTrain().get(0).equals(train.getTrain().get(1))) //ToDo better handle this exception
            throw new SameConnectionException();
        cityService.addCitiesFromTrain(train);
        return trainRepository.addTrain(train);
    }

}
