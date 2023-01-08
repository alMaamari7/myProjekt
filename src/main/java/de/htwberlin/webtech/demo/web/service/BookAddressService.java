package de.htwberlin.webtech.demo.web.service;


import de.htwberlin.webtech.demo.web.*;
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
        typeOfAddress.put(1L, "Privat");
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



public AddressBook fetchAddressePerson(Long personId){
    AddressBook addressBook;
    List<String> addressen = new ArrayList<>();
    var personRepository1= personRepository.findById(personId);
    List<AddressBookEntity> allPersonAddress = addressBookRepository.findAllByPersonId(personId);
    for (AddressBookEntity addressEntity : allPersonAddress){
        var address = addressRepository.findAllById(addressEntity.getAddressId());
        String typeOfAddress = changeIdToString(address.getKindOfAddress());
        var addressKlase = new Addresse(address.getId(),
                typeOfAddress,
                address.getStreet(),
                address.getHouseNumber(),
                address.getPostalCode(),
                address.getCity(),
                address.getCountry()
        );

        addressen.add(addressKlase.toString());
    }
    KontaktPerson person = null;
    if(personRepository1.isPresent()){
         person = new KontaktPerson(personRepository1.get().getId()
                                   ,personRepository1.get().getFirstName(),
                                    personRepository1.get().getSurname(),
                                    personRepository1.get().geteMailAddresse(),
                                    personRepository1.get().getPhoneNumber() );
    }
    String persninfos = person.toString();
        Map<String, List<String>> persnAdressen= new HashMap<>();
    persnAdressen.put(persninfos,addressen);
    addressBook = new AddressBook(persninfos,addressen);
    return addressBook;
}



    public String changeIdToString(Long id){
        typeOfAddress();
        String  type=  typeOfAddress.get(id);
        return type;
    }


    public AddressBook create(AddressBookCreateRequest request){
        AddressBook addressBook1;
        var person = new KontaktPersonCreateRequest(request.getPersonId(),request.getFirstName(),request.getSurname(),request.geteMailAddresse(),request.getPhoneNumber());
       var personEntity = new KontacktPersonEntity(person.getFirstName(),person.getSurname(),person.geteMailAddresse(),person.getPhoneNumber());
        var personWithId = personRepository.save(personEntity);
       var kontcktPerson = new KontaktPerson(personWithId.getId(),personWithId.getFirstName(),personWithId.getSurname(),personWithId.geteMailAddresse(),personWithId.getPhoneNumber());
        Long personId = personWithId.getId();
        var address = new AddresseCreateRequest(request.getAddresArt(),request.getStreet(),request.getHouseNumber(),request.getPostalCode(),request.getCity(),request.getCountry());
        Long addressArtId = getKeyFromValue(address.getAddresArt());
        var addressEntinty = new AddressEntity(personId,addressArtId,address.getStreet(),address.getHouseNumber(),address.getPostalCode(),address.getCity(),address.getCountry());
        var addressWithId = addressRepository.save(addressEntinty);
       var addressBook = new AddressBookEntity(personId,addressWithId.getId());
       var addresBookEntitny = addressBookRepository.save(addressBook);
       var addressKlasse= new Addresse(address.getId(),address.getAddresArt(),address.getStreet(),address.getHouseNumber(),address.getPostalCode(),address.getCity(),address.getCountry());
        //List<Addresse> adressen = new ArrayList<>();
       // Map<KontaktPerson, List<Addresse>> persnAdressen= new HashMap<>();
       // persnAdressen.put(kontcktPerson,adressen);
       // return new AddressBook(persnAdressen);
        List<String> addressen = new ArrayList<>();
        String personAddresse = addressKlasse.toString();
        Map<String, List<String>> persnAdressen= new HashMap<>();
        addressen.add(personAddresse);
        persnAdressen.put(kontcktPerson.toString(),addressen);
        addressBook1 = new AddressBook(kontcktPerson.toString(),addressen);
        return addressBook1;
    }



    public AddressBook update(Long addersseId, AddressBookCreateRequest request){
        AddressBook addressBook;

        var addressEntity = addressRepository.findAllById(addersseId);
        addressEntity.setStreet(request.getStreet());
        addressEntity.setHouseNumber(request.getHouseNumber());
        addressEntity.setPostalCode(request.getPostalCode());
        addressEntity.setCity(request.getCity());
        addressEntity.setCountry(request.getCountry());
        String addressArt = request.getAddresArt();
        Long idAddressArt = getKeyFromValue(addressArt);
        addressEntity.setKindOfAddress(idAddressArt);
        var addressen = addressRepository.save(addressEntity);
        var addressklasse = new Addresse(addressen.getId(),
                addressArt,
                addressen.getStreet(),
                addressen.getHouseNumber(),
                addressen.getPostalCode(),
                addressen.getCity(),
                addressen.getCountry());
        String addressString = addressklasse.toString();
        List<String> addresse = new ArrayList<>();
        addresse.add(addressString);


        var personRepository1= personRepository.findById(addressen.getPersonId());
        if (personRepository1.isEmpty()){
            return null;
        }

        var personOptional = personRepository1.get();
        personOptional.setFirstName(request.getFirstName());
        personOptional.setSurname(request.getSurname());
        personOptional.setPhoneNumber(request.getPhoneNumber());
        personOptional.seteMailAddresse(request.geteMailAddresse());
        var personEntity= personRepository.save(personOptional);
       var person = new KontaktPerson(personEntity.getId(),
                                      personEntity.getFirstName(),
                                      personEntity.getSurname(),
                                      personEntity.geteMailAddresse(),
                                      personEntity.getPhoneNumber());
       String personString = person.toString();



        addressBook = new AddressBook(personString, addresse);

        return addressBook;
    }

    public boolean deleteKontacktPerson (Long personID){
       List<AddressBookEntity> addressBookEntityList = addressBookRepository.findAllByPersonId(personID);
       for(AddressBookEntity addressBook : addressBookEntityList){
           addressBookRepository.deleteById(addressBook.getId());
           addressRepository.deleteById(addressBook.getAddressId());
           personRepository.deleteById(personID);
       }
       return true;
    }
}
