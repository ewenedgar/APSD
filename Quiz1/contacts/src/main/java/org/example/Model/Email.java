package org.example.Model;

public class Email {
    private String label;
    private String emailAddress;

    public Email(String label, String emailAddress){
        this.emailAddress = emailAddress;
        this.label = label;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label = label;
    }
}
