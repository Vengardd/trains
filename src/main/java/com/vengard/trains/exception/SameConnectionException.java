package com.vengard.trains.exception;

public class SameConnectionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Nie mozna dodac polaczenia a->a!";
    }
}
