package com.tunidesign.ordreservice.mapper;

import com.tunidesign.ordreservice.DTO.OrderRequestDTO;
import com.tunidesign.ordreservice.DTO.OrderResponseDTO;
import com.tunidesign.ordreservice.model.Order;

public interface OrderMapper {
    OrderResponseDTO orderToOrderDTO(Order order);
    Order OrderRequestDTOToOrder(OrderRequestDTO orderRequestDTO);
}
