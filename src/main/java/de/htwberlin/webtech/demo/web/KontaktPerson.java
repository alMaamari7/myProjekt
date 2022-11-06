package de.htwberlin.webtech.demo.web;

public class KontaktPerson {

    private long id;
    private String name;
    private String surname;
    private String eMailAddresse;
    private String phoneNumber;
    private Addresse addresse;


    public KontaktPerson(long id, String name, String surname, String eMailAddresse, String phoneNumber, Addresse addresse) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;
        this.addresse = addresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Addresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }
}
