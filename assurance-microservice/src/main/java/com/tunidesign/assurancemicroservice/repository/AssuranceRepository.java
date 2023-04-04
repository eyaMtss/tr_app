package com.tunidesign.assurancemicroservice.repository;

import com.tunidesign.assurancemicroservice.model.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuranceRepository extends JpaRepository <Assurance, Long>{

}
