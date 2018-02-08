package net.jwierzbo.rest.api;

import net.jwierzbo.rest.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseBody
    public String handleAllException(MovieNotFoundException ex) {
        return "GLOBAL-application handler: " + ex.getMessage();
    }
}