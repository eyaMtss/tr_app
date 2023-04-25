package com.tunidesign.contratmicroservice.repository;

import com.tunidesign.contratmicroservice.model.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends MongoRepository<Contrat, Long> {
    Contrat findByNumContrat(String numContrat);
}
