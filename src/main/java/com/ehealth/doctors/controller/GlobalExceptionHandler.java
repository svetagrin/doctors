package com.ehealth.doctors.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by vilyam on 18.02.17.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final int traceInclusion = 1;

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(Exception ex, HttpServletRequest request) throws JsonProcessingException {
        final ErrorObject errorObject = new ErrorObject(ex, request.getRequestURL().toString());

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        return new ResponseEntity<>(errorObject, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    class ErrorObject {
        public final InnerExceptionObject error;
        public final String url;

        public ErrorObject(Exception ex, String url) {
            this.error = new InnerExceptionObject(ex);
            this.url = url;
        }
    }

    class InnerExceptionObject {
        public final String message;
        public final StackTraceElement[] stackTrace;

        public InnerExceptionObject(Exception ex) {
            String exMsg = ex.getLocalizedMessage();
            this.message = exMsg != null ? exMsg : "";
            StackTraceElement[] trace = new StackTraceElement[traceInclusion];
            System.arraycopy(ex.getStackTrace(), 0, trace, 0, traceInclusion);
            this.stackTrace = trace;
        }
    }
}
