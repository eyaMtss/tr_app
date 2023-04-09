package com.tunidesign.facturemicroservice.repository;

import com.tunidesign.facturemicroservice.model.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends MongoRepository<Facture, Integer>
{
    List<Facture > findAll();
    Facture  findById(int id);
    Facture  save(Facture  facture);
    Facture deleteById(int id);
}
