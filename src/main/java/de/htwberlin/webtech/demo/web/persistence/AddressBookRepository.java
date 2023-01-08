package de.htwberlin.webtech.demo.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Long> {

    List<AddressBookEntity> findAllByPersonId(Long id);
    AddressBookEntity findByPersonId(Long id);
}
