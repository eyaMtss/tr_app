package com.tunidesign.ordremicroservice.service;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;

import java.util.List;

public interface OrderService {

        List<OrderResponseDTO> getOrders();
        OrderResponseDTO getOrderById(int id);
        OrderResponseDTO save(OrderRequestDTO orderRequestDTO);
        void deleteOrder(int id);
        OrderResponseDTO update(OrderRequestDTO orderRequestDTO);
}
