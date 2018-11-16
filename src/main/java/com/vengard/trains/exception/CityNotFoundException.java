package com.vengard.trains.exception;

public class CityNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Miasta nie znaleziono";
    }
}
