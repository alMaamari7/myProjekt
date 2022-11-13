package de.htwberlin.webtech.demo.web.service;


import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.persistence.KontacktPersonEntity;
import de.htwberlin.webtech.demo.web.persistence.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<KontaktPerson> findAll() {
        List<KontacktPersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(KontacktPersonEntity -> new KontaktPerson(
                     KontacktPersonEntity.getId(),
                     KontacktPersonEntity.getFirstName(),
                     KontacktPersonEntity.getSurname(),
                     KontacktPersonEntity.geteMailAddresse(),
                     KontacktPersonEntity.getPhoneNumber()
                ))
                .collect(Collectors.toList());
    }
}