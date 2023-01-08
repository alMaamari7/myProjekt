package de.htwberlin.webtech.demo.web.service;


import de.htwberlin.webtech.demo.web.AddressBook;
import de.htwberlin.webtech.demo.web.AddressBookCreateRequest;
import de.htwberlin.webtech.demo.web.Addresse;
import de.htwberlin.webtech.demo.web.AddresseCreateRequest;
import de.htwberlin.webtech.demo.web.persistence.AddressBookEntity;
import de.htwberlin.webtech.demo.web.persistence.AddressEntity;
import de.htwberlin.webtech.demo.web.persistence.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    public Map<Long, String> typeOfAddress = new HashMap<>();


    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Addresse> findAddressByPersonID(Long persId) {
        List<AddressEntity> addressEntityList = addressRepository.findAll();
        List<Addresse> addresseList = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntityList) {
            if(addressEntity.getPersonId()==persId) {
                var address = addressRepository.findAllById(addressEntity.getId());
                String typeOfAddress = changeIdToString(address.getKindOfAddress());
                var addressKlase = new Addresse(address.getId(),
                        typeOfAddress,
                        address.getStreet(),
                        address.getHouseNumber(),
                        address.getPostalCode(),
                        address.getCity(),
                        address.getCountry()
                );
                addresseList.add(addressKlase);
            }
        }
    return addresseList;
    }


    public Addresse createAddress(AddresseCreateRequest createRequest , Long personID){
        Long getKeyFromValue = getKeyFromValue(createRequest.getAddresArt());
        var addressEntity = new AddressEntity(personID,
                                              getKeyFromValue,
                                              createRequest.getStreet(),
                                              createRequest.getHouseNumber(),
                                              createRequest.getPostalCode(),
                                              createRequest.getCity(),
                                              createRequest.getCountry());

        var addressWithID = addressRepository.save(addressEntity);
        var address = new Addresse(addressWithID.getId(),
                                   createRequest.getAddresArt(),
                                   addressWithID.getStreet(),
                                   addressWithID.getHouseNumber(),
                                   addressWithID.getPostalCode(),
                                   addressWithID.getCity(),
                                   addressWithID.getCountry());

        return address;
    }



    public Addresse update(Long addersseId, AddresseCreateRequest request){
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
     return addressklasse;
    }



    public boolean deleteAddress(Long addressID){
      if(!addressRepository.existsById(addressID)){
          return false;
      }
      addressRepository.deleteById(addressID);
      return true;
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

    public String changeIdToString(Long id){
        typeOfAddress();
        String  type=  typeOfAddress.get(id);
        return type;
    }
}
