package com.tunidesign.Ordermicroservice.mapper;

import com.tunidesign.Ordermicroservice.DTO.OrderRequestDTO;
import com.tunidesign.Ordermicroservice.DTO.OrderResponseDTO;
import com.tunidesign.Ordermicroservice.model.Order;
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
