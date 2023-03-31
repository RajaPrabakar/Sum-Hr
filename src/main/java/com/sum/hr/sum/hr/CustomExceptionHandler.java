package com.sum.hr.sum.hr;

import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler implements CustomException {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("timestamp", System.currentTimeMillis());
        response.put("status", status.value());
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        response.put("errors", errors);
        return new ResponseEntity<Object>(response, status);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> myException(IllegalArgumentException illegalArgumentException)
    {
        return new ResponseEntity<>(illegalArgumentException.getMessage(),HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(DocumentException.class)
    protected ResponseEntity<Object> newException(DocumentException documentException)
    {
        return new ResponseEntity<>(documentException.getMessage(),HttpStatus.BAD_REQUEST);
    }
}