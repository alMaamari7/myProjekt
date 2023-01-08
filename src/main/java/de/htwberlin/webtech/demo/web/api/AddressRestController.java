package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.AddressBook;
import de.htwberlin.webtech.demo.web.Addresse;
import de.htwberlin.webtech.demo.web.AddresseCreateRequest;
import de.htwberlin.webtech.demo.web.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AddressRestController {

    public final AddressService addressService;

    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping( "/api/v2/address/{id}")
    public ResponseEntity<List<Addresse>> fetchAllByPersonId (@PathVariable Long id){
        var addresse = addressService.findAddressByPersonID(id);
         return addresse != null? ResponseEntity.ok(addresse) : ResponseEntity.notFound().build();
    }


    @PostMapping("/api/v2/address/{personID}")
    public  ResponseEntity<Void> createAddress (@RequestBody AddresseCreateRequest request, @PathVariable Long personID) throws URISyntaxException {
        var address = addressService.createAddress(request, personID);
        URI uri = new URI("/api/v2/address/"+personID +"/" + address.getId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping("/api/v2/address/{id}")
    public ResponseEntity<Addresse> update(@RequestBody AddresseCreateRequest request, @PathVariable Long id){
      var address = addressService.update(id,request);
        return address != null? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

@DeleteMapping("/api/v2/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        boolean successful = addressService.deleteAddress(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    }

