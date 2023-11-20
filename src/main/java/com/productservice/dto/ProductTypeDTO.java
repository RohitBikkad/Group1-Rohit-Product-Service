package com.productservice.dto;

import java.util.Map;



public class ProductTypeDTO {

	private Long id;
	private String productTypeName;
	private String productTypekey;
	private Map<String,String> attributeDefination;
	

	public ProductTypeDTO() {
		super();
	}

	public ProductTypeDTO(Long id, String productTypeName, String productTypekey,
			Map<String, String> attributeDefination) {
		super();
		this.id = id;
		this.productTypeName = productTypeName;
		this.productTypekey = productTypekey;
		this.attributeDefination = attributeDefination;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductTypekey() {
		return productTypekey;
	}

	public void setProductTypekey(String productTypekey) {
		this.productTypekey = productTypekey;
	}

	public Map<String, String> getAttributeDefination() {
		return attributeDefination;
	}

	public void setAttributeDefination(Map<String, String> attributeDefination) {
		this.attributeDefination = attributeDefination;
	}
	
	
	
	
	
}