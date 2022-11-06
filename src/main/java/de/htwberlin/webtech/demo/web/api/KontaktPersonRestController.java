package de.htwberlin.webtech.demo.web.api;


import de.htwberlin.webtech.demo.web.Addresse;
import de.htwberlin.webtech.demo.web.KontaktPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KontaktPersonRestController {

    private List<KontaktPerson> kontakte;
    Addresse ad1;
    Addresse ad2;


    public KontaktPersonRestController(){
        kontakte = new ArrayList<>();
        ad1 = new Addresse(1L,"dsds",2,33443,"berlin");
        ad2= new Addresse(2L,"vdfmsd",4,65544,"berlin");
        kontakte.add(new KontaktPerson(1L, "max","müller","gfgrfvvfvf", "44432343242",ad1));
        kontakte.add(new KontaktPerson(2L, "maxi","müllern","gfgrfvvfvf", "44432343242",ad2));

    }

    @GetMapping(path= "/api/v1/kontaktperson")
    public ResponseEntity <List<KontaktPerson>> fetchPerson(){
    return ResponseEntity.ok(kontakte);
    }
}
