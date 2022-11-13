package de.htwberlin.webtech.demo.web;

public class AddressBook {
   Long id;
   Long personId;
   Long addressId;


    public AddressBook(Long personId, Long addressId) {
        this.personId = personId;
        this.addressId = addressId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
