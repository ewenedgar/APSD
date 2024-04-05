package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String lastName;
    private String firstName;

    private String title;
    private String company;
    private List<Phone> phoneList;
    private List<Email> emailList;

    public Contact(String lastName,String firstName,String title,String company){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.title = title;
        this.phoneList = new ArrayList<>();
        this.emailList = new ArrayList<>();
    }
    public void setPhoneList(Phone phone){
        this.phoneList.add(phone);
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setEmailList(Email email) {
        this.emailList.add(email);
    }

    public List<Email> getEmailList() {
        return emailList;
    }
}

