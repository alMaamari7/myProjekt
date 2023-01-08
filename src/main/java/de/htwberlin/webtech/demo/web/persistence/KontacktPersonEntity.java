package de.htwberlin.webtech.demo.web.persistence;


import javax.persistence.*;

@Entity(name= "persons")
public class KontacktPersonEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name= "sur_name",nullable = false)
    private String surname;

    @Column(name= "e_mail")
    private String eMailAddresse;

    @Column(name= "phone_num")
    private String phoneNumber;




    public KontacktPersonEntity(String name, String surname, String eMailAddresse, String phoneNumber) {
        this.firstName = name;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;

    }


    protected KontacktPersonEntity(){}


    public Long getId() {
        return id;
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
