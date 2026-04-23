package com.divij.smartOrder.service;

import com.divij.smartOrder.dto.ProductRequestDTO;
import com.divij.smartOrder.dto.ProductResponseDTO;
import com.divij.smartOrder.entity.Product;
import com.divij.smartOrder.exception.ResourceNotFoundException;
import com.divij.smartOrder.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CacheEvict(value = "products", allEntries = true)
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

    @Cacheable("products")
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

    public ProductResponseDTO getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    @CacheEvict(value = "products", allEntries = true)
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        Product updated = productRepository.save(product);

        return new ProductResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getQuantity(),
                updated.getPrice()
        );
    }

    @CacheEvict(value = "products", allEntries = true)
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        productRepository.deleteById(id);
    }
}
