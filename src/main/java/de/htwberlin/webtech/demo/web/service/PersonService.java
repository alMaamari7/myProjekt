package de.htwberlin.webtech.demo.web.service;


import de.htwberlin.webtech.demo.web.KontaktPerson;
import de.htwberlin.webtech.demo.web.KontaktPersonCreateRequest;
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

    public KontaktPerson findById(Long id){
        var personEntity = personRepository.findAllById(id);
        var person = new KontaktPerson(personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getSurname(),
                personEntity.geteMailAddresse(),
                personEntity.getPhoneNumber());

        return person;
    }

    public KontaktPerson updatePerson (KontaktPersonCreateRequest request, Long id){
        var personEntity = personRepository.findAllById(id);
         personEntity.setSurname(request.getSurname());
         personEntity.setFirstName(request.getFirstName());
         personEntity.seteMailAddresse(request.geteMailAddresse());
         personEntity.seteMailAddresse(request.geteMailAddresse());
         var updatedPerson = personRepository.save(personEntity);
         var person = new KontaktPerson(updatedPerson.getId(),
                                        updatedPerson.getFirstName(),
                                        updatedPerson.getSurname(),
                                        updatedPerson.geteMailAddresse(),
                                        updatedPerson.getPhoneNumber());
         return person;
    }

    public KontaktPerson createPerson(KontaktPersonCreateRequest request){
        var personEntity = new KontacktPersonEntity(request.getFirstName(),
                                                    request.getSurname(),
                                                    request.geteMailAddresse(),
                                                    request.getPhoneNumber());
        var crratedPerson = personRepository.save(personEntity);
        var person = new KontaktPerson(crratedPerson.getId(),
                                       crratedPerson.getFirstName(),
                                       crratedPerson.getSurname(),
                                       crratedPerson.geteMailAddresse(),
                                       crratedPerson.getPhoneNumber());
        return person;
    }



    public KontaktPerson findByFirstNameOrLastName(String name){
        KontaktPerson person = null;
        var personEntityFirstName= personRepository.findByFirstName(name);
        if(personEntityFirstName!=  null) {
            var personFirstName = new KontaktPerson(personEntityFirstName.getId(),
                    personEntityFirstName.getFirstName(),
                    personEntityFirstName.getSurname(),
                    personEntityFirstName.geteMailAddresse(),
                    personEntityFirstName.getPhoneNumber());

            person=personFirstName;
        }


        var personEntityLastName= personRepository.findByFirstName(name);
        if(personEntityLastName!=null) {
            var personLastName = new KontaktPerson(personEntityLastName.getId(),
                    personEntityLastName.getFirstName(),
                    personEntityLastName.getSurname(),
                    personEntityLastName.geteMailAddresse(),
                    personEntityLastName.getPhoneNumber());

            person = personLastName;
        }
     return person;
    }

    public boolean deletePerson(Long id){
        if(!personRepository.existsById(id)){
            return false;
        }
        personRepository.deleteById(id);
        return true;
    }

}
