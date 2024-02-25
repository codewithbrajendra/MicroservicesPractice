package com.lcwd.user.service.UserService.exceptions;

import com.lcwd.user.service.UserService.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<APIResponse> resourceNotFoundHandler(ResourceNotFoundException resourceNotFoundException) {
             String message = resourceNotFoundException.getMessage();
             APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
             return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<APIResponse> globalException(Exception exception) {
        APIResponse response = APIResponse.builder().message("Exception occur in server -> "+exception.getMessage()).success(true).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
