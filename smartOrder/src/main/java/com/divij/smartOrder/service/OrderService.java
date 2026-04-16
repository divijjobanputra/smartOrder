package com.divij.smartOrder.service;

import com.divij.smartOrder.dto.OrderRequestDTO;
import com.divij.smartOrder.dto.OrderResponseDTO;
import com.divij.smartOrder.entity.Order;
import com.divij.smartOrder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO dto){
        Order order = new Order();
        order.setProductId(dto.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setStatus(dto.getStatus());
        Order saved = orderRepository.save(order);

        return new OrderResponseDTO(
                saved.getId(),
                saved.getProductId(),
                saved.getQuantity(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }

    public List<OrderResponseDTO> getAllOrder(){
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDTO> result = new ArrayList<>();

        for(Order o:orders){
            result.add(new OrderResponseDTO(
                    o.getId(),
                    o.getProductId(),
                    o.getQuantity(),
                    o.getStatus(),
                    o.getCreatedAt()
            ));
        }
        return result;
    }
}
