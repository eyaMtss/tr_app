package com.tunidesign.recumicroservice.repository;

import com.tunidesign.recumicroservice.model.Recu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecuRepository extends JpaRepository <Recu, Integer>
{
    List<Recu> findAll();
    Recu  findById(int id);
    Recu save(Recu  recu);
    Recu deleteById(int id);
}
