package com.tunidesign.recumicroservice.repository;

import com.tunidesign.recumicroservice.model.Recu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecuRepository extends MongoRepository<Recu, Long> {
}
