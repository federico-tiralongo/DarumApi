package com.postgresql.Daruma.config;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.postgresql.Daruma.model.RestError;
import com.postgresql.Daruma.model.exception.UnauthorizedException;

//Controller advice allows centralizing exception handling
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UnauthorizedException.class, InsufficientAuthenticationException.class,
            AuthenticationException.class, InvalidBearerTokenException.class })
    @ResponseBody
    public ResponseEntity<RestError> unauthorized(final Exception ex) {
        RestError error = new RestError(HttpStatus.UNAUTHORIZED,
                ex.getLocalizedMessage());
        // return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<RestError> defaultExceptionHandler(final Exception ex) {
        RestError error = new RestError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

}