package com.productservice.repository;

import com.productservice.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
	
	ProductVariant findByProductVariantKey(String productVariantKey);
}
