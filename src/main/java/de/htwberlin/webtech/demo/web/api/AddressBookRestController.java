package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.AddressBook;
import de.htwberlin.webtech.demo.web.AddressBookCreateRequest;
import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.service.BookAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AddressBookRestController {


    public final BookAddressService bookAddressService;

    public AddressBookRestController(BookAddressService bookAddressService) {
        this.bookAddressService = bookAddressService;
    }

/*
    @GetMapping(path= "/api/v1addresbook")
    public ResponseEntity<List<AddressBook>> fetchPerson(){
        return ResponseEntity.ok(bookAddressService.findAllAddressBookList());
    }

 */


    @PostMapping(path= "/api/v1addresbook")
    public ResponseEntity<Void> createKontakt(@RequestBody AddressBookCreateRequest request) throws URISyntaxException {
    var addressBook = bookAddressService.create(request);
    URI uri = new URI("/api/v1addresbook/"+ addressBook.getId());
    return ResponseEntity.created(uri).build();
    }

}
