package com.example.horelo.exception;

import com.example.horelo.model.CustomerOrder;

public class CustomerOrderNotFoundException extends Exception{
    public CustomerOrderNotFoundException(String message){super(message);}
}
