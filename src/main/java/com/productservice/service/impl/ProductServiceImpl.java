package com.productservice.service.impl;

import com.productservice.dto.ProductDTO;
import com.productservice.dto.ProductTypeDTO;
import com.productservice.entities.Product;
import com.productservice.entities.ProductType;
import com.productservice.repository.ProductRepository;
import com.productservice.repository.ProductTypeRepository;
import com.productservice.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
    	

//        Product product = modelMapper.map(productDTO, Product.class);
//        
////        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
////        productDTO.setProductType(productTypeDTO);
////        ProductType productType = modelMapper.map(productDTO.getProductType(), ProductType.class);
////        product.setProductType(productType);
//        
//        

//        Product savedProduct = productRepository.save(product);
//

//        return modelMapper.map(savedProduct, ProductDTO.class);
        
        
//       


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
}
