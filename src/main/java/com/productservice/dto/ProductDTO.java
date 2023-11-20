package com.productservice.dto;

import java.util.Set;

import com.productservice.entities.ProductVariant;

public class ProductDTO {
	
	private Long id;
    private String productKey;
    private String productName;
    private String productDescription;
    private Set<ProductVariantDTO> variants;
    private Set<ProductCategoryDTO> categories;
    private ProductTypeDTO productType;
    private ProductVariantDTO masterVariant;
    
    
	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String productKey, String productName, String productDescription,
			Set<ProductVariantDTO> variants, Set<ProductCategoryDTO> categories, ProductTypeDTO productType,
			ProductVariantDTO masterVariant) {
		super();
		this.id = id;
		this.productKey = productKey;
		this.productName = productName;
		this.productDescription = productDescription;
		this.variants = variants;
		this.categories = categories;
		this.productType = productType;
		this.masterVariant = masterVariant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Set<ProductVariantDTO> getVariants() {
		return variants;
	}

	public void setVariants(Set<ProductVariantDTO> variants) {
		this.variants = variants;
	}

	public Set<ProductCategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(Set<ProductCategoryDTO> categories) {
		this.categories = categories;
	}

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDTO productType) {
		this.productType = productType;
	}

	public ProductVariantDTO getMasterVariant() {
		return masterVariant;
	}

	public void setMasterVariant(ProductVariantDTO masterVariant) {
		this.masterVariant = masterVariant;
	}
    
	
	
    
    

}
