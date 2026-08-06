package com.supratim.payload.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder

public class CategoryDTO {


    private Long id;

    private String name;


//    private Store store;

    private Long storeId;
}
