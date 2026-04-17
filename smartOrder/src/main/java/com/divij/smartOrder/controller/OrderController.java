package com.divij.smartOrder.controller;

import com.divij.smartOrder.dto.OrderRequestDTO;
import com.divij.smartOrder.dto.OrderResponseDTO;
import com.divij.smartOrder.entity.Order;
import com.divij.smartOrder.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO dto){
        return orderService.createOrder(dto);
    }

    @GetMapping
    public List<OrderResponseDTO> getAllOrders(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public OrderResponseDTO findOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public OrderResponseDTO updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequestDTO dto){
        return orderService.updateOrder(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}