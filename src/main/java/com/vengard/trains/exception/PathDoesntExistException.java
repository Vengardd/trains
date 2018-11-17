package com.vengard.trains.exception;

public class PathDoesntExistException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Drogi nie odnaleziono!";
    }
}
