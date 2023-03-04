package com.tunidesign.shiftmicroservice.repository;


import com.tunidesign.shiftmicroservice.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository  extends JpaRepository<Shift, Integer> {
    List<Shift> findAll();
    Shift findById(int id);
    Shift save(Shift shift);
    Shift deleteById(int id);


}
