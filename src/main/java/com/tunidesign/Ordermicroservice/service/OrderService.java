package com.tunidesign.Ordermicroservice.service;

import com.tunidesign.Ordermicroservice.DTO.OrderRequestDTO;
import com.tunidesign.Ordermicroservice.DTO.OrderResponseDTO;

import java.util.List;

public interface OrderService {

        List<OrderResponseDTO> getOrder();
        OrderResponseDTO getOrder(String id);
        OrderResponseDTO save(OrderRequestDTO orderRequestDTO);
        void deleteOrder( String id);
        OrderResponseDTO update(OrderRequestDTO orderRequestDTO);
        List <OrderResponseDTO> getOrderByPostId(String id);
}
