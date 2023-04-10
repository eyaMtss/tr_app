package com.tunidesign.servicemicroservice.repository;

import com.tunidesign.servicemicroservice.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<Service, Long> {
}
