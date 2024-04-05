package org.example;

import com.google.gson.Gson;
import org.example.Model.Contact;

import org.example.Model.Email;
import org.example.Model.Phone;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Contact contact = new Contact("Edgar", "Ntende", "MIU", "Software Engineer");
        contact.setPhoneList(new Phone("Mobile", "641 233 99 85" ));
        contact.setEmailList(new Email("Work","edgarntende@gmial.com" ));

        Gson gson = new Gson();
        String json = gson.toJson(contact);

        System.out.println(json);
    }
}