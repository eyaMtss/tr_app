package com.tunidesign.facturemicroservice.repository;

import com.tunidesign.facturemicroservice.model.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends MongoRepository<Facture, Long> {
}
