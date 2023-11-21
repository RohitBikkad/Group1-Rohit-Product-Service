package com.productservice.service.impl;

import com.productservice.dto.PriceDTO;
import com.productservice.dto.ProductDTO;
import com.productservice.dto.ProductTypeDTO;
import com.productservice.entities.Price;
import com.productservice.entities.Product;
import com.productservice.entities.ProductType;
import com.productservice.entities.ProductVariant;
import com.productservice.repository.PriceRepository;
import com.productservice.repository.ProductRepository;
import com.productservice.repository.ProductTypeRepository;
import com.productservice.repository.ProductVariantRepository;
import com.productservice.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductTypeRepository productTypeRepository;
    
    @Autowired
    private PriceRepository priceRepository;
    
    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {


        Product product = modelMapper.map(productDTO, Product.class);
        if (productDTO.getProductType() != null) {
        	product.setProductType(modelMapper.map(productDTO.getProductType(), ProductType.class));
        }

        Product savedProduct = productRepository.save(product);

        return modelMapper.map(savedProduct, ProductDTO.class);
    }


    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .orElse(null);
    }

  
    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return modelMapper.map(product, ProductDTO.class);
                })
                .orElse(null);
    }
    
    
    @Override
	public ProductDTO getProductByKey(String productKey) {
		Product product = productRepository.findByProductKey(productKey);

		return modelMapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO updateProductById(Long id, ProductDTO updatedProductDTO) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " not found"));

     
        existingProduct.setProductName(updatedProductDTO.getProductName());
        existingProduct.setProductDescription(updatedProductDTO.getProductDescription());

        if (updatedProductDTO.getProductType() != null) {
            existingProduct.setProductType(modelMapper.map(updatedProductDTO.getProductType(), ProductType.class));
        }

        Product updatedProduct = productRepository.save(existingProduct);

        return modelMapper.map(updatedProduct, ProductDTO.class);
	}

	@Override
	public ProductDTO updateProductByKey(String productKey, ProductDTO updatedProductDTO) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepository.findByProductKey(productKey);

        if (existingProduct == null) {
            throw new EntityNotFoundException("Product with key " + productKey + " not found");
        }

        existingProduct.setProductName(updatedProductDTO.getProductName());
        existingProduct.setProductDescription(updatedProductDTO.getProductDescription());

        if (updatedProductDTO.getProductType() != null) {
            existingProduct.setProductType(modelMapper.map(updatedProductDTO.getProductType(), ProductType.class));
        }

        Product updatedProduct = productRepository.save(existingProduct);

        return modelMapper.map(updatedProduct, ProductDTO.class);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	public Set<PriceDTO> getProductPricesByProductId(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Set<ProductVariant> variants = product.getVariants();

            Set<PriceDTO> prices = new HashSet<>();

            for (ProductVariant variant : variants) {
                Set<Price> variantPrices = variant.getPrice();

                for (Price price : variantPrices) {
                    PriceDTO priceDTO = modelMapper.map(price, PriceDTO.class);
                    prices.add(priceDTO);
                }
            }

            return prices;
        }

        return Collections.emptySet();
    }
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

}



