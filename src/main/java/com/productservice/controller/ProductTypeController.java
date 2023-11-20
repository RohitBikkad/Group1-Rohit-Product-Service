package com.productservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.dto.ProductTypeDTO;
import com.productservice.entities.ProductType;
import com.productservice.service.ProductTypeService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/productType")
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	public ProductTypeController(ProductTypeService productTypeService) {
		super();
		this.productTypeService = productTypeService;
	}

	@PostMapping
	public ResponseEntity<ProductTypeDTO> saveProductTypeDto(@RequestBody ProductTypeDTO productTypeDto) {
		ProductTypeDTO savedProductTypeDto = productTypeService.saveProductType(productTypeDto);
		return new ResponseEntity<>(savedProductTypeDto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductType>> getAllProductType() {
		return ResponseEntity.ok(productTypeService.getAllProductType());

	}
	

	@GetMapping("/{productTypeKey}")
	@Transactional
	public ResponseEntity<ProductTypeDTO> getProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) {
		ProductTypeDTO productTypeDto = productTypeService.getProductTypeByKey(productTypeKey);
		return ResponseEntity.ok(productTypeDto);
	}


	@DeleteMapping("/{productTypeKey}")
	@Transactional
	public ResponseEntity<ProductType> deleteProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) {
		ProductType productType = productTypeService.deleteProductTypeByKey(productTypeKey);
		return ResponseEntity.ok(productType);
	}
	
	@PutMapping("/{productTypeKey}")
	public ResponseEntity<ProductTypeDTO> updateProductTypeByKey(@RequestBody ProductTypeDTO productTypeDto,
														@PathVariable("productTypeKey") String productTypeKey) {
		ProductTypeDTO updateProductTypeDto = productTypeService.updateProductTypeByKey(productTypeDto,productTypeKey);
		if (updateProductTypeDto != null) {
	        return new ResponseEntity<>(updateProductTypeDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	

}