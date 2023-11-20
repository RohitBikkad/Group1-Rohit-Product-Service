package com.productservice.service;

import java.util.List;

import com.productservice.dto.ProductTypeDTO;
import com.productservice.entities.ProductType;


public interface ProductTypeService {
	ProductTypeDTO saveProductType(ProductTypeDTO productTypeDto);
	ProductTypeDTO getProductTypeByKey(String productTypeKey);
	List<ProductType> getAllProductType();
	ProductType deleteProductTypeByKey(String productTypeKey);
	ProductTypeDTO updateProductTypeByKey(ProductTypeDTO productTypeDto, String productTypeKey);
}