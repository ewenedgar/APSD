package org.example.Model;

public class Phone {
    private String label;
    private String phoneNumber;

    public Phone(String label, String phoneNumber){
        this.phoneNumber = phoneNumber;
        this.label = label;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label = label;
    }

}
