package com.divij.smartOrder.controller;

import com.divij.smartOrder.dto.ProductRequestDTO;
import com.divij.smartOrder.dto.ProductResponseDTO;
import com.divij.smartOrder.entity.Product;
import com.divij.smartOrder.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO dto){
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
