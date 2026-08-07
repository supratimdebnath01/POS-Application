package com.supratim.payload.dto;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {

    private Long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private ProductDTO product;

    private Long orderId;
}
