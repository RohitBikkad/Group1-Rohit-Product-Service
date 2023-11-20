package com.productservice.service;

import com.productservice.dto.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {
    
    ProductCategoryDTO saveCategory(ProductCategoryDTO categoryDTO);

    ProductCategoryDTO getCategoryById(Long id);

    List<ProductCategoryDTO> getAllCategories();

    ProductCategoryDTO deleteCategory(Long categoryId);
}
