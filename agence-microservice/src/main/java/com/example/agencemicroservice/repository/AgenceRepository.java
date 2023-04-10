package com.example.agencemicroservice.repository;

import com.example.agencemicroservice.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenceRepository extends MongoRepository<Agence, Long>
{
    List<Agence > findAll();
    Agence  findById(int id);
    Agence  save(Agence  agence);
    Agence deleteById(int id);
}
