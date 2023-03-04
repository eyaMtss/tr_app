package com.tunidesign.societeRemorquagemicroservice.repository;

import com.tunidesign.societeRemorquagemicroservice.model.SocieteRemorquage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocieteRemorquageRepository extends JpaRepository<SocieteRemorquage, Integer> {
    List<SocieteRemorquage> findAll();
    SocieteRemorquage findById(int id);
    SocieteRemorquage save(SocieteRemorquage societeRemorquage);
    SocieteRemorquage deleteById(int id);


}
