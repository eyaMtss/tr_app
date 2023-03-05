package com.tunidesign.servicemicroservice.repository;

import com.tunidesign.servicemicroservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository <Service, Integer>
{
    List<Service> findAll();
    Service  findById(int id);

    Service  save(Service  service);
    Service deleteById(int id);
}