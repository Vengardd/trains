package com.vengard.trains.rest;

import com.vengard.trains.model.Connection;
import com.vengard.trains.model.Train;
import com.vengard.trains.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public Train showTrain() {
        return new Train();
    }

    @PostMapping("/api/trains")
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

}
