package com.tunidesign.ordreservice.service;

import com.tunidesign.ordreservice.DTO.OrderRequestDTO;
import com.tunidesign.ordreservice.DTO.OrderResponseDTO;

import java.util.List;

public interface OrderService {

        List<OrderResponseDTO> getOrder();
        OrderResponseDTO getOrder(String id);
        OrderResponseDTO save(OrderRequestDTO orderRequestDTO);
        void deleteOrder( String id);
        OrderResponseDTO update(OrderRequestDTO orderRequestDTO);
        List <OrderResponseDTO> getOrderByPostId(String id);
}
