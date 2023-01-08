package de.htwberlin.webtech.demo.web.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByPersonId(Long id);

    List<AddressEntity> findAll();

    AddressEntity findAllById(Long id);




}
