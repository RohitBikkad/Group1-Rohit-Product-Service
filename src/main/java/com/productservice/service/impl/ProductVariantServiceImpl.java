package com.productservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.productservice.dto.ProductDTO;
import com.productservice.dto.ProductVariantDTO;
import com.productservice.entities.Product;
import com.productservice.entities.ProductVariant;
import com.productservice.repository.ProductVariantRepository;
import com.productservice.service.ProductService;
import com.productservice.service.ProductVariantService;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Override
    public ProductVariantDTO createProductVariant(ProductVariantDTO productVariantDTO) {
        ProductVariant productVariant = modelMapper.map(productVariantDTO, ProductVariant.class);

        ProductDTO productDTO = productService.getProductById(productVariantDTO.getProductId());

        Product product = modelMapper.map(productDTO, Product.class);

        productVariant.setProduct(product);

        ProductVariant savedProductVariant = productVariantRepository.save(productVariant);
        return modelMapper.map(savedProductVariant, ProductVariantDTO.class);
    }

    @Override
    public ProductVariantDTO getProductVariantById(Long productVariantId) {
        return productVariantRepository.findById(productVariantId)
            .map(productVariant -> modelMapper.map(productVariant, ProductVariantDTO.class))
            .orElse(null);
    }

    @Override
    public List<ProductVariantDTO> getAllProductVariants() {
        List<ProductVariant> productVariants = productVariantRepository.findAll();
        return productVariants.stream()
            .map(productVariant -> modelMapper.map(productVariant, ProductVariantDTO.class))
            .collect(Collectors.toList());
    }
}
