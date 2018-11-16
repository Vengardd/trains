package com.vengard.trains.exception;

public class TrainExistingException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Takie polaczenie juz istnieje!";
    }
}
