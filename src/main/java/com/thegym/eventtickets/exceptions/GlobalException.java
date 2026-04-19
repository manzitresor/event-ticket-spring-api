package com.thegym.eventtickets.exceptions;

import com.thegym.eventtickets.domain.dtos.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException e) {
        log.error("Caught User not Found Exception",e);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("Validation error: ", ex);

        ErrorDto errorDto = new ErrorDto();
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream().findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Validation error occurred");
        errorDto.setError(errorMessage);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorDto> handleConstraintViolation(
            ConstraintViolationException ex
    ){
        log.error("Validation error: ", ex);

        ErrorDto errorDto = new ErrorDto();
        String errorMessage = ex.getConstraintViolations().stream().findFirst().map(violation -> violation.getPropertyPath() + ": " + violation.getMessage()).orElse("Validation error occurred");
        errorDto.setError(errorMessage);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("An error occurred: ", ex);
        ErrorDto errorDto = new ErrorDto("An unexpected error occurred. Please try again later.");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
