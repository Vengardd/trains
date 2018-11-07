package com.vengard.trains.rest;

import com.vengard.trains.model.AddTrainModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @GetMapping
    public AddTrainModel showAddTrainModel() {
        return new AddTrainModel();
    }

}
