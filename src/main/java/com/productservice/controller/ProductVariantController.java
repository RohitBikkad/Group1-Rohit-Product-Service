package com.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productservice.dto.ProductVariantDTO;
import com.productservice.service.ProductVariantService;

import java.util.List;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {

    @Autowired
    private ProductVariantService productVariantService;

    @PostMapping
    public ResponseEntity<ProductVariantDTO> createProductVariant(@RequestBody ProductVariantDTO productVariantDTO) {
        ProductVariantDTO createdProductVariant = productVariantService.createProductVariant(productVariantDTO);
        return new ResponseEntity<>(createdProductVariant, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<ProductVariantDTO>> getAllProductVariants() {
        List<ProductVariantDTO> productVariants = productVariantService.getAllProductVariants();
        return new ResponseEntity<>(productVariants, HttpStatus.OK);
    }
}
