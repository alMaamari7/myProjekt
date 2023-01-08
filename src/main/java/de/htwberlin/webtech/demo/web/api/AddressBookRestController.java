package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.AddressBook;
import de.htwberlin.webtech.demo.web.AddressBookCreateRequest;
import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.service.BookAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AddressBookRestController {


    public final BookAddressService bookAddressService;

    public AddressBookRestController(BookAddressService bookAddressService) {
        this.bookAddressService = bookAddressService;
    }


    @GetMapping(path= "/api/v1/addresbook/{id}")
    public ResponseEntity<AddressBook> fetchInfosByID(@PathVariable Long id){
        var bookAddresse = bookAddressService.fetchAddressePerson(id);
        return bookAddresse != null? ResponseEntity.ok(bookAddresse) : ResponseEntity.notFound().build();
    }



    @PostMapping(path= "/api/v1/addresbook")
    public ResponseEntity<Void> createKontakt(@RequestBody AddressBookCreateRequest request) throws URISyntaxException {
    var addressBook = bookAddressService.create(request);
    URI uri = new URI("/api/v1addresbook/"+ addressBook.getId());
    return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/addresbook/{id}")
    public ResponseEntity<AddressBook> updatePerson(@PathVariable Long id, @RequestBody AddressBookCreateRequest request) {
        var bookAddresse = bookAddressService.update(id, request);
        return bookAddresse != null? ResponseEntity.ok(bookAddresse) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/api/v1/addresbook/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        boolean successful = bookAddressService.deleteKontacktPerson(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
