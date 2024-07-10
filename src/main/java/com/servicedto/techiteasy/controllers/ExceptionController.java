package com.servicedto.techiteasy.controllers;

import com.servicedto.techiteasy.exceptions.BadRequestException;
import com.servicedto.techiteasy.exceptions.ProductNameTooLongException;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler (value = RecordNotFoundException.class)
    public ResponseEntity<String> exception (RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> exception (IndexOutOfBoundsException exception) {
        return new ResponseEntity<>("No television with that id.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = ProductNameTooLongException.class)
    public ResponseEntity<String> exception (ProductNameTooLongException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = BadRequestException.class)
    public ResponseEntity<String> exception (BadRequestException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = UsernameNotFoundException.class)
    public ResponseEntity<String> exception (UsernameNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
