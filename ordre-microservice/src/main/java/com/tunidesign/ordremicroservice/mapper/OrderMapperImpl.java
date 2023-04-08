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
                .serie(order.getSerie())
                .numImmatriculation(order.getNumImmatriculation())
                .typeImmatriculation(order.getTypeImmatriculation())
                .positionAAtt(order.getPositionAAtt())
                .positionALong(order.getPositionALong())
                .positionBAtt(order.getPositionBAtt())
                .positionBLong(order.getPositionBLong())
                .positionCAtt(order.getPositionCAtt())
                .positionCLong(order.getPositionCLong())
                .img1(order.getImg1())
                .img2(order.getImg2())
                .img3(order.getImg3())
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
                .numImmatriculation(orderRequestDTO.getNumImmatriculation())
                .numChassis(orderRequestDTO.getNumChassis())
                .typeImmatriculation(orderRequestDTO.getTypeImmatriculation())
                .positionAAtt(orderRequestDTO.getPositionAAtt())
                .positionALong(orderRequestDTO.getPositionALong())
                .positionBAtt(orderRequestDTO.getPositionBAtt())
                .positionBLong(orderRequestDTO.getPositionBLong())
                .positionCAtt(orderRequestDTO.getPositionCAtt())
                .positionCLong(orderRequestDTO.getPositionCLong())
                .img1(orderRequestDTO.getImg1())
                .img2(orderRequestDTO.getImg2())
                .img3(orderRequestDTO.getImg3())
                .serie(orderRequestDTO.getSerie())

                .build();

    }
}