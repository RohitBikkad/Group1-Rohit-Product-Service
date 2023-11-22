package com.productservice.controller;

import com.productservice.dto.PriceDTO;
import com.productservice.dto.ProductDTO;
import com.productservice.service.ProductService;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    


	@PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = productService.saveProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        String errorMessage = "Product not found for id: " + id;
        
        return productDTO != null
                ? new ResponseEntity<>(productDTO, HttpStatus.OK)
                : new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        ProductDTO deletedProductDTO = productService.deleteProduct(id);
        String errorMessage = "Product not found for id: " + id;
        
        return deletedProductDTO != null
                ? new ResponseEntity<>("Product  deleted successfully", HttpStatus.OK)
                : new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
  
    @GetMapping("/key/{productKey}")
    public ResponseEntity<ProductDTO> getProductByKey(@PathVariable("productKey") String productKey) {
        ProductDTO productDto = productService.getProductByKey(productKey);
        
        if (productDto != null) {
        	return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else {
        	
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Long id, @RequestBody ProductDTO updatedProductDTO) {
        ProductDTO updatedProduct = productService.updateProductById(id, updatedProductDTO);
        return updatedProduct != null
                ? new ResponseEntity<>(updatedProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/key/{productKey}")
    public ResponseEntity<ProductDTO> updateProductByKey(@PathVariable String productKey, @RequestBody ProductDTO updatedProductDTO) {
        ProductDTO updatedProduct = productService.updateProductByKey(productKey, updatedProductDTO);
        return updatedProduct != null
                ? new ResponseEntity<>(updatedProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/{productId}/prices")
    public ResponseEntity<Set<PriceDTO>> getProductPrices(@PathVariable Long productId) {
        Set<PriceDTO> prices = productService.getProductPricesByProductId(productId);

        if (!prices.isEmpty()) {
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    
    


}

