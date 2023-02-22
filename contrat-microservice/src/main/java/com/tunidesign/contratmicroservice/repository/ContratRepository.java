package com.tunidesign.contratmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tunidesign.contratmicroservice.model.Contrat ;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository <Contrat, Integer>
{
    List<Contrat> findAll();
    Contrat findById(int id);
    Contrat save(Contrat  contrat);
    Contrat deleteById(int id);
}
