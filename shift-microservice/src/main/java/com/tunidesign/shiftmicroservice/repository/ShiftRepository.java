package com.tunidesign.shiftmicroservice.repository;


import com.tunidesign.shiftmicroservice.model.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository  extends MongoRepository<Shift, Long> {

}
