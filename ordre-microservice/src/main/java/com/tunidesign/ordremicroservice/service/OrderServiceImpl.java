package com.tunidesign.ordremicroservice.service;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.mapper.OrderMapperImpl;
import com.tunidesign.ordremicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private OrderMapperImpl orderMapper;

    @Override
    public List<OrderResponseDTO> getOrders() {
        return orderRepository.findAll().stream().map(order -> orderMapper.orderToOrderResponseDTO(order)).toList();
    }

    @Override
    public OrderResponseDTO getOrderById(int id) {
        return orderMapper.orderToOrderResponseDTO(orderRepository.findById(id));
    }

    @Override
    public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {
        Date timeRequest = new Date();
        orderRequestDTO.setOrderTimeRequest(timeRequest);
        return orderMapper.orderToOrderResponseDTO(orderRepository.save(orderMapper.orderRequestDTOToOrder(orderRequestDTO)));
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponseDTO update(OrderRequestDTO orderRequestDTO) {


        return orderMapper.orderToOrderResponseDTO(orderRepository.save(orderMapper.orderRequestDTOToOrder(orderRequestDTO)));
    }

}
