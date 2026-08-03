package com.supratim.service;


import com.supratim.exceptions.UserException;
import com.supratim.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCatgory(CategoryDTO dto) throws Exception;
    List<CategoryDTO> getCategoriesByStore(Long storeId);
    CategoryDTO updateCatgory(Long id, CategoryDTO dto) throws Exception;
    void deleteCatgory(Long id) throws Exception;
}
