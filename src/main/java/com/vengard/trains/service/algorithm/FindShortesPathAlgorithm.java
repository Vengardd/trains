package com.vengard.trains.service.algorithm;

import com.vengard.trains.model.City;
import com.vengard.trains.model.Connection;
import com.vengard.trains.model.Graph;

public interface FindShortesPathAlgorithm {
    Connection findShortestPath(Graph graph, City start, City destination);
}
