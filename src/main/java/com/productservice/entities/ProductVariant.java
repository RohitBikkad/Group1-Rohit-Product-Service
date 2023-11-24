package com.productservice.entities;

import java.util.Map;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ProductVariant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String sku;
	
	private String productVariantKey; 
	
	public String getProductVariantKey() {
		return productVariantKey;
	}

	public void setProductVariantKey(String productVariantKey) {
		this.productVariantKey = productVariantKey;
	}

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productVariant")
    private Set<Price> price;

	@ElementCollection
	@CollectionTable(name = "Attributes", joinColumns = {@JoinColumn(name = "product_variant_id", referencedColumnName = "id") })
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributes;
	
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
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

	public Product getProduct() {
		return product;
	}

	public Set<Price> getPrice() {
		return price;
	}

	public void setPrice(Set<Price> price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductVariant() {
		super();
	}
	
	
	

}
