package com.tunidesign.contratmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tunidesign.contratmicroservice.model.Contrat ;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository <Contrat, Long>
{
    Contrat findByNumContratAndNumChassis(String numContrat, Long numChassis);
}
