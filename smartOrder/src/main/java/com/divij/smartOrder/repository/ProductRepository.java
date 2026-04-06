package com.divij.smartOrder.repository;


import com.divij.smartOrder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
