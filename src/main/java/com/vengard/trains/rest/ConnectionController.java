package com.vengard.trains.rest;

import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import com.vengard.trains.service.ConnectionService;
import com.vengard.trains.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private GraphService graphService;

    @GetMapping("/api/shortest_rules")
    public Connection getConnection(@RequestParam("start") String start, @RequestParam("destination") String destination) {
        return connectionService.createConnection(start, destination);
    }

}
