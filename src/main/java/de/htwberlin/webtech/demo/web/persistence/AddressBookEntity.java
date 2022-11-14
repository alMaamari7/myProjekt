package de.htwberlin.webtech.demo.web.persistence;


import javax.persistence.*;

@Entity(name = "book_address")
public class AddressBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private Long personId;

    @Column(nullable = false)
    private Long addressId;


    public AddressBookEntity(Long personId, Long addressId) {
        this.personId = personId;
        this.addressId = addressId;
    }

    protected AddressBookEntity() {

    }

    public Long getId() {
        return id;
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
