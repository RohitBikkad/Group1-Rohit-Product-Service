package com.productservice.service.impl;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.dto.ProductTypeDTO;
import com.productservice.entities.ProductType;
import com.productservice.repository.ProductTypeRepository;
import com.productservice.service.ProductTypeService;



@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Autowired
	private ProductTypeRepository productTypeRepo;
	@Autowired
    private ModelMapper modelMapper;

	

	public ProductTypeServiceImpl(ProductTypeRepository productTypeRepo, ModelMapper modelMapper) {
		super();
		this.productTypeRepo = productTypeRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductTypeDTO saveProductType(ProductTypeDTO productTypeDto) {
		ProductType productType = modelMapper.map(productTypeDto, ProductType.class);
		ProductType savedProductType = productTypeRepo.save(productType);
        return modelMapper.map(savedProductType, ProductTypeDTO.class);
	}


	@Override
	public ProductTypeDTO getProductTypeByKey(String productTypeKey) {
		ProductType productType =productTypeRepo.findByProductTypeKey(productTypeKey);
		
		return modelMapper.map(productType, ProductTypeDTO.class);
	}

	@Override
	public List<ProductType> getAllProductType() {
		return productTypeRepo.findAll();
	}

	@Override
	public ProductType deleteProductTypeByKey(String productTypeKey) {
		ProductType productType =productTypeRepo.findByProductTypeKey(productTypeKey);
		if(productType!=null) {
			productTypeRepo.delete(productType);
			return productType; 
		}else {
		return null;
		}
	}


	@Override
	public ProductTypeDTO updateProductTypeByKey(ProductTypeDTO productTypeDto, String productTypeKey) {
		ProductType existingProductType = productTypeRepo.findByProductTypeKey(productTypeKey);
		
		if (existingProductType!=null) {
			existingProductType.setProductTypeName(productTypeDto.getProductTypeName());
			existingProductType.setProductTypeKey(productTypeDto.getProductTypekey());
			existingProductType.setAttributeDefination(productTypeDto.getAttributeDefination());
			ProductType savedProductType = productTypeRepo.save(existingProductType);
			
			return modelMapper.map(savedProductType, ProductTypeDTO.class);
		}
		
		return null;
	}





}