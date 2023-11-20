package com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.productservice.entities.ProductType;


@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	ProductType findByProductTypeKey(String productTypeKey);
}