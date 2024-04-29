package com.example.horelo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HoreloWebAPIExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleUserNotFoundException(Exception userNotFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", userNotFoundException.getMessage());
        return errorMessageMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleItemNotFoundException(Exception notFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", notFoundException.getMessage());
        return errorMessageMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleAllergyNotFoundException(Exception notFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", notFoundException.getMessage());
        return errorMessageMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleCustomerOrderNotFoundException(Exception notFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", notFoundException.getMessage());
        return errorMessageMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleCompanyNotFoundException(Exception notFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", notFoundException.getMessage());
        return errorMessageMap;
    }
}
