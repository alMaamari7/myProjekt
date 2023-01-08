package de.htwberlin.webtech.demo.web;

public class KontaktPerson {

    private Long id;
    private String firstName;
    private String surname;
    private String eMailAddresse;
    private String phoneNumber;




    public KontaktPerson(Long id, String name, String surname, String eMailAddresse, String phoneNumber) {
        this.id=id;
        this.firstName = name;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return firstName+" "+surname+" "+phoneNumber+" "+eMailAddresse+" ";
    }
}
