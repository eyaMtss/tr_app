package com.tunidesign.Ordermicroservice.web;

import com.tunidesign.Ordermicroservice.exceptions.OrderIntrouvableException;
import com.tunidesign.Ordermicroservice.model.Order;
import com.tunidesign.Ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/Ordres")
    public List<Order> listeOrdres()
    {
        return orderRepository.findAll();
    }

    @GetMapping(value = "/Ordres/{id}")
    public Order afficherUnOrder(@PathVariable int id) {
        Order order = orderRepository.findById(id);
        if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
        return order;
    }

    @PostMapping(value = "/PasserUnOrdre")
    public void passerUnOrder(@RequestBody Order order)
    {
        orderRepository.save(order);
    }
    @DeleteMapping (value = "/AnnulerUnOrdre/{id}")
    public void supprimerUnOrder(@PathVariable int id)
    {
        Order order = orderRepository.deleteById(id);
        if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/ModifierUnOrdre")
    public void modiferUnOrder(@RequestBody Order order)
    {
        orderRepository.save(order);
        if(order==null) throw new OrderIntrouvableException("Cet ordre est INTROUVABLE. ");

    }
}
