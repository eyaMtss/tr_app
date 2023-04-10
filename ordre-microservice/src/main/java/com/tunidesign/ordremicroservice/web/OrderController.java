package com.tunidesign.ordremicroservice.web;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.exceptions.OrderIntrouvableException;
import com.tunidesign.ordremicroservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ordre")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @GetMapping("/getAll")
    public List<OrderResponseDTO> listeOrdres() {
        return orderService.getOrders();
    }
    @GetMapping(value = "/getById/{id}")
    public OrderResponseDTO afficherUnOrder(@PathVariable Long id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
        return order;
    }
    @PostMapping(value = "/add")
    public OrderResponseDTO passerUnOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
       return  orderService.save(orderRequestDTO);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnOrder(@PathVariable Long id)
    {
        orderService.deleteOrder(id);
        //if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
    }
    @PutMapping (value = "/update")
    public OrderResponseDTO modiferUnOrder(@RequestBody OrderRequestDTO orderRequestDTO)
    {
        OrderResponseDTO order = orderService.save(orderRequestDTO);
        if(order==null) throw new OrderIntrouvableException("Cet ordre est INTROUVABLE. ");
        return order;
    }

    @PutMapping (value = "/uploadPhoto")
    public OrderResponseDTO ajouterPhotos( @RequestParam MultipartFile img1,@RequestParam MultipartFile img2,@RequestParam MultipartFile img3, Long id) throws IOException {
        OrderResponseDTO order = orderService.updatePhotos(img1,img2,img3,id);
        if(order==null) throw new OrderIntrouvableException("Cet ordre est INTROUVABLE. ");
        return order;
    }
}
