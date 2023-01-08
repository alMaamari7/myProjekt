package de.htwberlin.webtech.demo.web;

public class AddressBookCreateRequest {

    private String firstName;
    private String surname;
    private String eMailAddresse;
    private String phoneNumber;
    private String addresArt;
    private String street;
    private int houseNumber;
    private int postalCode;
    private String city;
    private String country;
    private Long personId;
    private Long adderssId;


    KontaktPersonCreateRequest kontaktPersonCreateRequest;
    AddresseCreateRequest addresseCreateRequest;


    public AddressBookCreateRequest(Long personID,Long id, String firstName, String surname, String eMailAddresse, String phoneNumber, String addresArt, String street, int houseNumber, int postalCode, String city, String country) {
        this.adderssId=id;
        this.personId=personID;
        this.firstName = firstName;
        this.surname = surname;
        this.eMailAddresse = eMailAddresse;
        this.phoneNumber = phoneNumber;
        this.addresArt = addresArt;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.kontaktPersonCreateRequest=new KontaktPersonCreateRequest(personID, firstName,surname,eMailAddresse,phoneNumber);
        this.addresseCreateRequest= new AddresseCreateRequest(addresArt,street,houseNumber,postalCode,city,country);
    }


    public AddressBookCreateRequest() {}

    public KontaktPersonCreateRequest getKontaktPersonCreateRequest() {
        return kontaktPersonCreateRequest;
    }

    public void setKontaktPersonCreateRequest(KontaktPersonCreateRequest kontaktPersonCreateRequest) {
        this.kontaktPersonCreateRequest = kontaktPersonCreateRequest;
    }

    public AddresseCreateRequest getAddresseCreateRequest() {
        return addresseCreateRequest;
    }

    public void setAddresseCreateRequest(AddresseCreateRequest addresseCreateRequest) {
        this.addresseCreateRequest = addresseCreateRequest;
    }

    public Long getAdderssId() {
        return adderssId;
    }

    public void setAdderssId(Long adderssId) {
        this.adderssId = adderssId;
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

    public String getAddresArt() {
        return addresArt;
    }

    public void setAddresArt(String addresArt) {
        this.addresArt = addresArt;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
