package com.vengard.trains.service;

import com.vengard.trains.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {


    @Autowired
    private GraphService graphService;

    public Connection createConnection(String start, String destination) {
        return graphService.findShortestPath(start, destination);
    }

}
