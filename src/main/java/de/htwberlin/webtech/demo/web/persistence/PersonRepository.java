package de.htwberlin.webtech.demo.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<KontacktPersonEntity, Long> {

   Optional<KontacktPersonEntity> findById(Long id);
    KontacktPersonEntity findAllById(Long id);
   List<KontacktPersonEntity> findAll();
   KontacktPersonEntity findByFirstName(String name);
   KontacktPersonEntity findBySurname(String name);
}
