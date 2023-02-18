package com.tunidesign.facturemicroservice.repository;

import com.tunidesign.facturemicroservice.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository <Facture, Integer>
{
    List<Facture > findAll();
    Facture  findById(int id);
    Facture  save(Facture  facture);
    Facture deleteById(int id);
}
