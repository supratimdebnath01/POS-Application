package com.supratim.service;


import com.supratim.exceptions.UserException;
import com.supratim.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto) throws Exception;
    List<CategoryDTO> getCategoriesByStore(Long storeId) throws Exception;
    CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception;
    void deleteCategory(Long id) throws Exception;

}
