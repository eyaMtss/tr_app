package com.tunidesign.ordremicroservice.web;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.exceptions.OrderIntrouvableException;
import com.tunidesign.ordremicroservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @GetMapping("/Ordres")
    public List<OrderResponseDTO> listeOrdres() {
        return orderService.getOrders();
    }
    @GetMapping(value = "/Ordres/{id}")
    public OrderResponseDTO afficherUnOrder(@PathVariable int id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
        return order;
    }
    @PostMapping(value = "/PasserUnOrdre")
    public void passerUnOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        orderService.save(orderRequestDTO);
    }
    @DeleteMapping (value = "/AnnulerUnOrdre/{id}")
    public void supprimerUnOrder(@PathVariable int id)
    {
        orderService.deleteOrder(id);
        //if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
    }
    @PutMapping (value = "/ModifierUnOrdre")
    public OrderResponseDTO modiferUnOrder(@RequestBody OrderRequestDTO orderRequestDTO)
    {
        OrderResponseDTO order = orderService.save(orderRequestDTO);
        if(order==null) throw new OrderIntrouvableException("Cet ordre est INTROUVABLE. ");
        return order;
    }
}
