package com.thegym.eventtickets.exceptions;

import com.thegym.eventtickets.domain.dtos.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {


    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("An error occurred: ", ex);
        ErrorDto errorDto = new ErrorDto("An unexpected error occurred. Please try again later.");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
