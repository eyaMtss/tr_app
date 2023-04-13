package com.tunidesign.contratmicroservice.repository;

import com.tunidesign.contratmicroservice.model.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratRepository extends MongoRepository<Contrat, Long> {
    Contrat findByNumContrat(String numContrat);
    //@Query(value = "SELECT u FROM Contrat u WHERE u.numContrat = :numContrat AND u.numChassis = :numChassis", nativeQuery = true)
    //List<Contrat> findContrat(@Param("numContrat") String numContrat, @Param("numChassis") int numChassis);

}
