package com.akumar.ws.mobilews.exceptions;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.akumar.ws.mobilews.modal.response.ErrorMessage;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(final Exception ex, final WebRequest webRequest) {

        final String message = ( ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString());
        final ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(final Exception ex,
            final WebRequest webRequest) {

        final String message = ( ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.toString()) +
                "--> testing";
        final ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
