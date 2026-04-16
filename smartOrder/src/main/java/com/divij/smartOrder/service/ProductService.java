package com.divij.smartOrder.service;

import com.divij.smartOrder.dto.ProductRequestDTO;
import com.divij.smartOrder.dto.ProductResponseDTO;
import com.divij.smartOrder.entity.Product;
import com.divij.smartOrder.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        Product saved = productRepository.save(product);

        return new ProductResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getQuantity(),
                saved.getPrice()
        );
    }

    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> result = new ArrayList<>();
        for(Product p:products){
            result.add(new ProductResponseDTO(
                    p.getId(),
                    p.getName(),
                    p.getQuantity(),
                    p.getPrice()
            ));
        }
        return result;
    }
}
