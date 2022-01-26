package com.tsystems.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by HP on 05-10-2021.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<Object> exception(NoDataFoundException exception) {
        return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
