package com.bezf.authorizationservice.exceptionHandlers;

import com.bezf.authorizationservice.exceptions.InvalidCredentials;
import com.bezf.authorizationservice.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials ic) {
        return new ResponseEntity<>(ic.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser uu) {
        return new ResponseEntity<>(uu.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
