package com.tunidesign.ordremicroservice.service;

import com.tunidesign.ordremicroservice.DTO.OrderRequestDTO;
import com.tunidesign.ordremicroservice.DTO.OrderResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface OrderService {

        List<OrderResponseDTO> getOrders();
        OrderResponseDTO getOrderById(Long id);
        OrderResponseDTO save(OrderRequestDTO orderRequestDTO);
        void deleteOrder(Long id);
        OrderResponseDTO update(OrderRequestDTO orderRequestDTO);

        OrderResponseDTO updatePhotos(MultipartFile img1 ,MultipartFile img2,MultipartFile img3,Long id ) throws IOException;
}
