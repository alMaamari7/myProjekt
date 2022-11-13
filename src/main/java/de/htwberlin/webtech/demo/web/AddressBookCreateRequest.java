package de.htwberlin.webtech.demo.web;

public class AddressBookCreateRequest {


    KontaktPersonCreateRequest kontaktPersonCreateRequest;
    AddresseCreateRequest addresseCreateRequest;


    public AddressBookCreateRequest(KontaktPersonCreateRequest kontaktPersonCreateRequest, AddresseCreateRequest addresseCreateRequest) {
        this.kontaktPersonCreateRequest = kontaktPersonCreateRequest;
        this.addresseCreateRequest = addresseCreateRequest;
    }


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
}
