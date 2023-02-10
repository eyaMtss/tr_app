package com.tunidesign.Ordermicroservice.mapper;

import com.tunidesign.Ordermicroservice.DTO.OrderRequestDTO;
import com.tunidesign.Ordermicroservice.DTO.OrderResponseDTO;
import com.tunidesign.Ordermicroservice.model.Order;

public interface OrderMapper {
    OrderResponseDTO orderToOrderDTO(Order order);
    Order OrderRequestDTOToOrder(OrderRequestDTO orderRequestDTO);
}
