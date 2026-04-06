package com.divij.smartOrder.controller;

import com.divij.smartOrder.entity.Order;
import com.divij.smartOrder.service.OrderService;
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
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrder();
    }
}
