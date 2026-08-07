package com.supratim.payload.dto;


import com.supratim.modal.Customer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
public class OrderDTO {
    private Long id;

    private Double totalAmount;

    private LocalDateTime createdAt;

    private Long BranchId;

    private Long customerId;

    private BranchDTO branch;


    private UserDto cashier;


    private Customer customer;

    private List<OrderItemDTO> items;
}
