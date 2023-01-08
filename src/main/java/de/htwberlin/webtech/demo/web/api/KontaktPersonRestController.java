package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.Addresse;
import de.htwberlin.webtech.demo.web.AddresseCreateRequest;
import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.KontaktPersonCreateRequest;
import de.htwberlin.webtech.demo.web.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class KontaktPersonRestController {


    public final PersonService personService;

    public KontaktPersonRestController(PersonService personService){

        this.personService = personService;
    }

    @GetMapping(path= "/api/v3/kontaktperson")
    public ResponseEntity <List<KontaktPerson>> fetchPerson(){
        return ResponseEntity.ok(personService.findAll());
    }



    @PostMapping("/api/v3/kontaktperson")
    public  ResponseEntity<Void> createAddress (@RequestBody KontaktPersonCreateRequest request) throws URISyntaxException {
        var person = personService.createPerson(request);
        URI uri = new URI("/api/v3/kontaktperson/"+ person.getId());
        return ResponseEntity.created(uri).build();
    }



    @PutMapping("/api/v3/kontaktperson/{id}")
    public ResponseEntity<KontaktPerson> update(@RequestBody KontaktPersonCreateRequest request, @PathVariable Long id){
        var person = personService.updatePerson(request, id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }


    @GetMapping("/api/v3/kontaktperson/{id}")
    public ResponseEntity<KontaktPerson> findById(@PathVariable Long id){
        var person = personService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/v3/kontaktperson/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        boolean successful = personService.deletePerson(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
