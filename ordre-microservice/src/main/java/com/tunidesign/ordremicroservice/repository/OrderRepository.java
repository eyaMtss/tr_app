package com.tunidesign.ordremicroservice.repository;

import com.tunidesign.ordremicroservice.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

}
