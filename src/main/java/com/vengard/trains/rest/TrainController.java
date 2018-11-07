package com.vengard.trains.rest;

import com.vengard.trains.model.Train;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @GetMapping
    public Train showTrain() {
        return new Train();
    }

}
