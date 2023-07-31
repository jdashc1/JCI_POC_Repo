package com.user.service.exceptions;


import com.user.service.Payload.APIResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<APIResponce> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        APIResponce res = APIResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

}
