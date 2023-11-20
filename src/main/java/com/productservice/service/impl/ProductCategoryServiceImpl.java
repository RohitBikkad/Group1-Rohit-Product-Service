package com.productservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.dto.ProductCategoryDTO;
import com.productservice.entities.ProductCategory;
import com.productservice.repository.ProductCategoryRepository;
import com.productservice.service.ProductCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductCategoryDTO saveCategory(ProductCategoryDTO categoryDTO) {
        ProductCategory category = modelMapper.map(categoryDTO, ProductCategory.class);
        return modelMapper.map(productCategoryRepository.save(category), ProductCategoryDTO.class);
    }

    @Override
    public ProductCategoryDTO getCategoryById(Long id) {
        return productCategoryRepository.findById(id)
                .map(category -> modelMapper.map(category, ProductCategoryDTO.class))
                .orElse(null);
    }

    @Override
    public List<ProductCategoryDTO> getAllCategories() {
        List<ProductCategory> categoryList = productCategoryRepository.findAll();
        return categoryList.stream()
                .map(category -> modelMapper.map(category, ProductCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO deleteCategory(Long categoryId) {
        return productCategoryRepository.findById(categoryId)
                .map(category -> {
                    productCategoryRepository.delete(category);
                    return modelMapper.map(category, ProductCategoryDTO.class);
                })
                .orElse(null);
    }
}
