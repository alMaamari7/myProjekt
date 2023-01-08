package de.htwberlin.webtech.demo.web.persistence;


import javax.persistence.*;

@Entity(name= "addresse")
public class AddressEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;



    @Column(name="person_id")
    private Long personId;



    @Column(name="address_type_id")
    private Long kindOfAddress;

    @Column(nullable = false)
    private String street;

    @Column(name="house_num",nullable = false)
    private int houseNumber;

    @Column(name="post_code",nullable = false)
    private int postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public AddressEntity(Long personId, Long addressId, String street, int houseNumber, int postalCode, String city, String country) {
       this.personId=personId;
       this.kindOfAddress= addressId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country=country;
    }

    protected AddressEntity(){}


    public Long getPersonId() {
        return personId;
    }


    public Long getKindOfAddress() {
        return kindOfAddress;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public void setKindOfAddress(Long kindOfAddress) {
        this.kindOfAddress = kindOfAddress;
    }
}
