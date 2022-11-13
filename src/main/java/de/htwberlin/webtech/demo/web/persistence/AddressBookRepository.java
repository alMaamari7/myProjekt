package de.htwberlin.webtech.demo.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Long> {

    List<AddressBookEntity> findAllByPersonId(Long id);
}
