package com.divij.smartOrder.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderResponseDTO implements Serializable {
    private Long id;
    private Long productId;
    private Integer quantity;
    private String status;
    private LocalDateTime createdAt;

    public OrderResponseDTO() {}

    public OrderResponseDTO(Long id, Long productId, Integer quantity, String status, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
