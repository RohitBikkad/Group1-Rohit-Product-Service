package com.productservice.service;

import com.productservice.dto.PriceDTO;
import com.productservice.dto.ProductDTO;
import com.productservice.entities.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO deleteProduct(Long id);
    
    ProductDTO getProductByKey(String productKey);

	ProductDTO updateProductById(Long id, ProductDTO updatedProductDTO);

	ProductDTO updateProductByKey(String productKey, ProductDTO updatedProductDTO);

	Set<PriceDTO> getProductPricesByProductId(Long productId);


}
