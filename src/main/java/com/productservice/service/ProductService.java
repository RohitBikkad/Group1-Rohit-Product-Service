package com.productservice.service;

import com.productservice.dto.ProductDTO;
import com.productservice.entities.Product;

import java.util.List;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO deleteProduct(Long id);
    
    
}
