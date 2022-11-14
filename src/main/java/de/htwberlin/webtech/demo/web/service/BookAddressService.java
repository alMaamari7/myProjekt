package de.htwberlin.webtech.demo.web.service;


import de.htwberlin.webtech.demo.web.AddressBook;
import de.htwberlin.webtech.demo.web.AddressBookCreateRequest;
import de.htwberlin.webtech.demo.web.AddresseCreateRequest;
import de.htwberlin.webtech.demo.web.KontaktPersonCreateRequest;
import de.htwberlin.webtech.demo.web.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookAddressService {

   private final AddressRepository addressRepository;
    private final AddressBookRepository addressBookRepository;
    private final PersonRepository personRepository;
    public Map<Long, String> typeOfAddress = new HashMap<>();

    public BookAddressService(AddressRepository addressRepository, AddressBookRepository addressBookRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.addressBookRepository = addressBookRepository;
        this.personRepository = personRepository;
    }

    public void typeOfAddress(){
        typeOfAddress.put(1L, "Private");
        typeOfAddress.put(2L, "Arbeit");
        typeOfAddress.put(3L, "Schule");
        typeOfAddress.put(4L, "Anders");
    }

    public Long getKeyFromValue(String value){
        typeOfAddress();
        Long key= 0L;
        for(Map.Entry<Long, String> entry : typeOfAddress.entrySet()){
          if (entry.getValue().equals(value)){
              key= entry.getKey();
          }
        }
          return key;
    }


/*
public AddressBook fetchAddressePerson(){

   return new AddressBook();
}

 */

    public String changeIdToString(Long id){
        typeOfAddress();
       Long art =0L;
        String type= "Null";
        List<AddressEntity> addressen = addressRepository.findAllByPersonId(id);
        for( AddressEntity person : addressen){
            art = person.getKindOfAddress();
             type=  typeOfAddress.get(art);

        };
        return type;
    }


    public AddressBook create(AddressBookCreateRequest request){
        var person = new KontaktPersonCreateRequest(request.getKontaktPersonCreateRequest().getFirstName(),request.getKontaktPersonCreateRequest().getSurname(),request.getKontaktPersonCreateRequest().geteMailAddresse(),request.getKontaktPersonCreateRequest().getPhoneNumber());
       var personEntity = new KontacktPersonEntity(person.getFirstName(),person.getSurname(),person.geteMailAddresse(),person.getPhoneNumber());
        var personWithId = personRepository.save(personEntity);
        Long personId = personWithId.getId();
        var address = new AddresseCreateRequest(request.getAddresseCreateRequest().getAddresArt(),request.getAddresseCreateRequest().getStreet(),request.getAddresseCreateRequest().getHouseNumber(),request.getAddresseCreateRequest().getHouseNumber(),request.getAddresseCreateRequest().getCity(),request.getAddresseCreateRequest().getCountry());
        Long addressArtId = getKeyFromValue(address.getAddresArt());
        var addressEntinty = new AddressEntity(personId,addressArtId,address.getStreet(),address.getHouseNumber(),address.getPostalCode(),address.getCity(),address.getCountry());
        var addressWithId = addressRepository.save(addressEntinty);
       return new AddressBook(personId,addressWithId.getId());
    }

/*
    private AddressBook trnasformEntity (AddressEntity addressEntity, Long personId){
        var person = personRepository.findAllById(personId);
         KontacktPersonEntity  savedPerson = null;
        for(KontacktPersonEntity kontacktPersonEntity: person)
            savedPerson = new KontacktPersonEntity(kontacktPersonEntity.getFirstName(), kontacktPersonEntity.getSurname(), kontacktPersonEntity.geteMailAddresse(), kontacktPersonEntity.getPhoneNumber());

        return new AddressBook(savedPerson.getId(),savedPerson.getFirstName(),savedPerson.getSurname(),savedPerson.getPhoneNumber(),savedPerson.geteMailAddresse(),addressEntity.getKindOfAddress(),addressEntity.getStreet(),addressEntity.getHouseNumber(),addressEntity.getPostalCode(),addressEntity.getCity(),addressEntity.getCountry());
    }

 */
}
