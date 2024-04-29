package com.example.horelo.exception;

import com.example.horelo.model.Company;

public class CompanyNotFoundException extends Exception{
    public CompanyNotFoundException(String message){super(message);}
}
