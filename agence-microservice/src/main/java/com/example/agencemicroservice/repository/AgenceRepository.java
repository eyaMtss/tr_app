package com.example.agencemicroservice.repository;

import com.example.agencemicroservice.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenceRepository extends MongoRepository<Agence, Long>
{
    @Query(value = "SELECT u FROM Agence u WHERE u.idAssurance = :idAssurance", nativeQuery = true)
    List<Agence> findByIdAssurance(@Param("idAssurance") Long idAssurance);

}
