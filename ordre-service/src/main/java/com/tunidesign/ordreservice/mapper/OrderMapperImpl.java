package com.tunidesign.ordreservice.mapper;

import com.tunidesign.ordreservice.DTO.OrderRequestDTO;
import com.tunidesign.ordreservice.DTO.OrderResponseDTO;
import com.tunidesign.ordreservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDTO orderToOrderDTO(Order order) {
        return null;
    }

    @Override
    public Order OrderRequestDTOToOrder(OrderRequestDTO orderRequestDTO) {
        return null;
    }

}
