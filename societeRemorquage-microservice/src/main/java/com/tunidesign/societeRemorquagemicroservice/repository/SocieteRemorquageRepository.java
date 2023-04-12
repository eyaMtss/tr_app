package com.tunidesign.societeRemorquagemicroservice.repository;

import com.tunidesign.societeRemorquagemicroservice.model.SocieteRemorquage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocieteRemorquageRepository extends MongoRepository<SocieteRemorquage, Long> {

}
