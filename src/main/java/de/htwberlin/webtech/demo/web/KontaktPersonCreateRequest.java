package de.htwberlin.webtech.demo.web;

public class KontaktPersonCreateRequest {



    private String firstName;
    private String surname;
    private String eMailAddresse;
    private String phoneNumber;


    public KontaktPersonCreateRequest(String firstName, String surname, String eMailAddresse, String phoneNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMailAddresse() {
        return eMailAddresse;
    }

    public void seteMailAddresse(String eMailAddresse) {
        this.eMailAddresse = eMailAddresse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
