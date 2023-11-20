package com.productservice.service;

import com.productservice.dto.ProductVariantDTO;

import java.util.List;

public interface ProductVariantService {

    ProductVariantDTO createProductVariant(ProductVariantDTO productVariantDTO);

    ProductVariantDTO getProductVariantById(Long productVariantId);

    List<ProductVariantDTO> getAllProductVariants();
}
