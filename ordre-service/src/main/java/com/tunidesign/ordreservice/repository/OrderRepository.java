package com.tunidesign.ordreservice.repository;

import com.tunidesign.ordreservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer>{
    List<Order> findAll();
    Order findById(int id);
    Order save(Order order);
    Order deleteById(int id);
}
