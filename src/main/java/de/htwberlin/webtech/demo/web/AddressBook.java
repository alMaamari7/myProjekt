package de.htwberlin.webtech.demo.web;

import java.util.List;
import java.util.Map;

public class AddressBook {
    private Long id;
    private String person;
    private List<String> personadderssen;


    public AddressBook(String person, List<String> personadderssen) {
        this.person = person;
        this.personadderssen = personadderssen;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public List<String> getPersonadderssen() {
        return personadderssen;
    }

    public void setPersonadderssen(List<String> personadderssen) {
        this.personadderssen = personadderssen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
