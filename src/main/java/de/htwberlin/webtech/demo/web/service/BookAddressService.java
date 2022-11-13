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
   public List<Void> findAllAddressBookList() {

       String type = typeOfAdress();
       Long id = 0L;
       List<AddressEntity> addressEntityList = addressRepository.findAllByPersonId();
       for (AddressEntity address : addressEntityList) {
           id = address.getPersonId();
       }
       List<KontacktPersonEntity> persons = personRepository.findAllById(id);
       List<AddressBook> addressBookList = new ArrayList<>();
   return addressBookList;
   }
*/

    public String typeOfAdress(){
        typeOfAddress();
       Long art =0L;
        String type= "Null";
        List<AddressEntity> addressen = addressRepository.findAllByPersonId();
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
        var adressbook = new AddressBookCreateRequest(person, address);
        Long addresId= getKeyFromValue( request.getAddresseCreateRequest().getAddresArt());
        var addressEntinty = new AddressEntity(personId,addresId,adressbook.getAddresseCreateRequest().getStreet(),adressbook.getAddresseCreateRequest().getHouseNumber(),adressbook.getAddresseCreateRequest().getPostalCode(),adressbook.getAddresseCreateRequest().getCity(),adressbook.getAddresseCreateRequest().getCountry());
       return new AddressBook(personId,addresId);
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
