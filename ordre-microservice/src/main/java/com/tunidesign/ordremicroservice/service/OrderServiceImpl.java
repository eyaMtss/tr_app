package com.tunidesign.ordremicroservice.service;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import com.tunidesign.ordremicroservice.mapper.OrderMapper;
import com.tunidesign.ordremicroservice.mapper.OrderMapperImpl;
import com.tunidesign.ordremicroservice.model.entity.Order;
import com.tunidesign.ordremicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

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

    @Override
    public OrderResponseDTO updatePhotos(MultipartFile img1, MultipartFile img2, MultipartFile img3,int id ) throws IOException {

        Order order= orderRepository.findById(id);
        order.setImg1(img1.getBytes());
        order.setImg2(img2.getBytes());
        order.setImg3(img3.getBytes());
        return orderMapper.orderToOrderResponseDTO(orderRepository.save(order));




    }

}
