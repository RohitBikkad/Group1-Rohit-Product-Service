package com.productservice.dto;

public class PriceDTO {
	
	private Long id;
    private String priceKey;
    private String sku;
    private Double centAmount;
    private String currency;
    private Long productVariantId;
	
    public PriceDTO() {
		super();
	}

	public PriceDTO(Long id, String priceKey, String sku, Double centAmount, String currency, Long productVariantId) {
		super();
		this.id = id;
		this.priceKey = priceKey;
		this.sku = sku;
		this.centAmount = centAmount;
		this.currency = currency;
		this.productVariantId = productVariantId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriceKey() {
		return priceKey;
	}

	public void setPriceKey(String priceKey) {
		this.priceKey = priceKey;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Double getCentAmount() {
		return centAmount;
	}

	public void setCentAmount(Double centAmount) {
		this.centAmount = centAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getProductVariantId() {
		return productVariantId;
	}

	public void setProductVariantId(Long productVariantId) {
		this.productVariantId = productVariantId;
	}
    
    

}
