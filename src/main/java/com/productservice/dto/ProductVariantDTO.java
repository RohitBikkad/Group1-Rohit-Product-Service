package com.productservice.dto;

import java.util.Set;

public class ProductVariantDTO {

    private Long id;
    private String sku;
    private Long productId;
    private Set<PriceDTO> price;
    private ProductVariantDTO masterVariant;
	
    public ProductVariantDTO() {
		super();
	}

	public ProductVariantDTO(Long id, String sku, Long productId, Set<PriceDTO> price,
			ProductVariantDTO masterVariant) {
		super();
		this.id = id;
		this.sku = sku;
		this.productId = productId;
		this.price = price;
		this.masterVariant = masterVariant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Set<PriceDTO> getPrice() {
		return price;
	}

	public void setPrice(Set<PriceDTO> price) {
		this.price = price;
	}

	public ProductVariantDTO getMasterVariant() {
		return masterVariant;
	}

	public void setMasterVariant(ProductVariantDTO masterVariant) {
		this.masterVariant = masterVariant;
	}
    
    
    
}
