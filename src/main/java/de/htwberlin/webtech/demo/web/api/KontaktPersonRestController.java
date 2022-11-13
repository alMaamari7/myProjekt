package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KontaktPersonRestController {


    public final PersonService personService;

    public KontaktPersonRestController(PersonService personService){

        this.personService = personService;
    }

    @GetMapping(path= "/api/v1/kontaktperson")
    public ResponseEntity <List<KontaktPerson>> fetchPerson(){
        return ResponseEntity.ok(personService.findAll());
    }




}
