package de.htwberlin.webtech.demo.web;

public class KontaktPersonCreateRequest {



    private String firstName;
    private String surname;
    private String eMailAddresse;
    private String phoneNumber;
    private Long id;


    public KontaktPersonCreateRequest( Long id, String firstName, String surname, String eMailAddresse, String phoneNumber) {
        this.id= id;
        this.firstName = firstName;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;
    }


    public KontaktPersonCreateRequest() {}


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
