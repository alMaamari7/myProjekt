package de.htwberlin.webtech.demo.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<KontacktPersonEntity, Long> {

    List<KontacktPersonEntity> findAllByFirstName(String firstName);

    List<KontacktPersonEntity> findAllById(Long id);
}
