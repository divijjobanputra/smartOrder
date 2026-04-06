package com.divij.smartOrder.repository;


import com.divij.smartOrder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
