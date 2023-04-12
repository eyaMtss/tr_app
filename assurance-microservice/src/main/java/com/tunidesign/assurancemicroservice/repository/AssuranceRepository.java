package com.tunidesign.assurancemicroservice.repository;

import com.tunidesign.assurancemicroservice.model.Assurance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssuranceRepository extends MongoRepository<Assurance, Long> {

}
