package com.supratim.mapper;

import com.supratim.modal.Branch;
import com.supratim.modal.Inventory;
import com.supratim.modal.Product;
import com.supratim.payload.dto.InventoryDTO;

public class InventoryMapper {

    public static InventoryDTO toDTO(Inventory inventory) {
        return InventoryDTO.builder()
                .id(inventory.getId())
                .branchId(inventory.getBranch().getId())
                .productId(inventory.getProduct().getId())
                .product(ProductMapper.toDTO(inventory.getProduct()))
                .quantity(inventory.getQuantity())
                .build();
    }

    public static Inventory toEntity(InventoryDTO inventoryDTO,
                                     Branch branch,
                                     Product product) {
        return Inventory.builder()
                .branch(branch)
                .product(product)
                .quantity(inventoryDTO.getQuantity())
                .build();
    }
}
