package com.productservice.repository;

import com.productservice.entities.Price;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {


	Optional<Price> findByproductVariantId(Long productVariantId);

    
}
