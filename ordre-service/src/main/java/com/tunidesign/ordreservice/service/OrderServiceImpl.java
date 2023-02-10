package com.tunidesign.ordreservice.service;

import com.tunidesign.ordreservice.DTO.OrderRequestDTO;
import com.tunidesign.ordreservice.DTO.OrderResponseDTO;
import com.tunidesign.ordreservice.mapper.OrderMapper;
import com.tunidesign.ordreservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    public List<OrderResponseDTO> getOrder() {
        return null;
    }

    @Override
    public OrderResponseDTO getOrder(String id) {
        return null;
    }

    @Override
    public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public OrderResponseDTO update(OrderRequestDTO orderRequestDTO) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> getOrderByPostId(String id) {
        return null;
    }
}
