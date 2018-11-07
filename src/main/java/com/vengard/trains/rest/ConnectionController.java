package com.vengard.trains.rest;

import com.vengard.trains.model.Connection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionController {



    @GetMapping("/api/shortest_rules")
    public Connection getConnection(@RequestParam("start") String start, @RequestParam("destination") String destination) {
        return new Connection();
    }

}
