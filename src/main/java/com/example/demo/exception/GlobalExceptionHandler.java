package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.MessageConstants;
import com.example.demo.common.ResponseModel;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseModel> handleEntityNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(
                new ResponseModel(
                        MessageConstants.FAILED,
                        MessageConstants.NOT_FOUND_STATUS_CODE,
                        ex.getMessage(),
                        null),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(
                ResponseModel.error("Something went wrong: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
