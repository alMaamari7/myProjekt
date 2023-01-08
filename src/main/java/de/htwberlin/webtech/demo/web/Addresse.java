package de.htwberlin.webtech.demo.web;

public class Addresse {

   private Long id;
   private String addresArt;
   private String street;
   private int houseNumber;
   private int postalCode;
   private String city;
   private String country;


    public Addresse( Long id, String art ,String street, int houseNumber, int postalCode, String city, String country) {
        this.id=id;
        this.addresArt=art;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country=country;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return addresArt+" "+street + " " + houseNumber+" "+ postalCode+ " "+city+" "+ country;
    }
}
