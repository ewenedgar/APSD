package edu.miu.cs.cs489.lab7.adsapp.advice;

import edu.miu.cs.cs489.lab7.adsapp.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ADSWebAPIExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(Exception patientNotFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessageMap;
    }

}
