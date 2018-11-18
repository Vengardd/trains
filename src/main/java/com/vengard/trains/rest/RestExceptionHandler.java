package com.vengard.trains.rest;

import com.vengard.trains.exception.CityNotFoundException;
import com.vengard.trains.exception.PathDoesntExistException;
import com.vengard.trains.exception.SameConnectionException;
import com.vengard.trains.exception.TrainExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Object> cityNotFoundExceptionHandler(CityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PathDoesntExistException.class)
    public ResponseEntity<Object> pathDoesntExistExceptionHandler(PathDoesntExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SameConnectionException.class)
    public ResponseEntity<Object> sameConnectionExceptionHandler(SameConnectionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TrainExistingException.class)
    public ResponseEntity<Object> trainExistingExceptionHandler(TrainExistingException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
