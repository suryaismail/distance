package com.si.distance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DistanceCalculatorExceptionController {
   @ExceptionHandler(value = IllegalArgumentException.class)
   public ResponseEntity<Object> exception(IllegalArgumentException exception) {
      return new ResponseEntity<>("Only METERS and YARDS allowed", HttpStatus.BAD_REQUEST);
   }
}