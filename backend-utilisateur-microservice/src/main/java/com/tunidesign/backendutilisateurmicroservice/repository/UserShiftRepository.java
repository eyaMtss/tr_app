package com.tunidesign.backendutilisateurmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunidesign.backendutilisateurmicroservice.model.entity.UserShift;

@Repository
public interface UserShiftRepository extends JpaRepository<UserShift, Long>{

}
