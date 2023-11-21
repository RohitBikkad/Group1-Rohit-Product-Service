package com.productservice.dto;

import java.util.Map;
import java.util.Set;

public class ProductVariantDTO {

    private Long id;
    private String sku;
    private Long productId;
    private Set<PriceDTO> price;
    private Map<String, String> attributes;

	
    public Map<String, String> getAttributes() {
		return attributes;
	}



	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}



	public ProductVariantDTO() {
		super();
	}

	

	public ProductVariantDTO(Long id, String sku, Long productId, Set<PriceDTO> price) {
		super();
		this.id = id;
		this.sku = sku;
		this.productId = productId;
		this.price = price;
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


    
    
    
}
