package com.tunidesign.ordremicroservice.mapper;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
     @Override
    public OrderResponseDTO orderToOrderResponseDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .people(order.getPeople())
                .breakdownType(order.getBreakdownType())
                .breakdownDetails(order.getBreakdownDetails())
                .isLoaded(order.getIsLoaded())
                .orderTimeRequest(order.getOrderTimeRequest())
                .orderTimeAccept(order.getOrderTimeAccept())
                .idVehicule(order.getIdVehicule())
                .positionAAtt(order.getPositionAAtt())
                .positionALong(order.getPositionALong())
                .positionBAtt(order.getPositionBAtt())
                .positionBLong(order.getPositionBLong())
                .positionCAtt(order.getPositionCAtt())
                .positionCLong(order.getPositionCLong())
                .build();
    }
    @Override
    public Order orderRequestDTOToOrder(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
                .people(orderRequestDTO.getPeople())
                .telephone(orderRequestDTO.getTelephone())
                .breakdownType(orderRequestDTO.getBreakdownType())
                .breakdownDetails(orderRequestDTO.getBreakdownDetails())
                .isLoaded(orderRequestDTO.getIsLoaded())
                .orderTimeRequest(orderRequestDTO.getOrderTimeRequest())
                .orderTimeAccept(orderRequestDTO.getOrderTimeRequest())
                .idVehicule(orderRequestDTO.getIdVehicule())
                .positionAAtt(orderRequestDTO.getPositionAAtt())
                .positionALong(orderRequestDTO.getPositionALong())
                .positionBAtt(orderRequestDTO.getPositionBAtt())
                .positionBLong(orderRequestDTO.getPositionBLong())
                .positionCAtt(orderRequestDTO.getPositionCAtt())
                .positionCLong(orderRequestDTO.getPositionCLong())
                .build();
    }
}