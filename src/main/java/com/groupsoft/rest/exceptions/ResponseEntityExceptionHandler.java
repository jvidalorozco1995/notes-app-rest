package com.grRoupsoft.rest.exceptions;

import com.groupsoft.rest.exceptions.NoteNotFoundException;
import com.groupsoft.rest.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),
                request.getDescription(false));
        return  new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleNoteNotFoundException(NoteNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),
                request.getDescription(false));
        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "Validacion fallida",
                ex.getBindingResult().toString());
        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}

