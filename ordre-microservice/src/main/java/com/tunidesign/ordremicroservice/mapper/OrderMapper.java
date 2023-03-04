package com.tunidesign.ordremicroservice.mapper;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.model.entity.Order;

public interface OrderMapper {
    OrderResponseDTO orderToOrderResponseDTO(Order order);
    Order orderRequestDTOToOrder(OrderRequestDTO orderRequestDTO);
}
