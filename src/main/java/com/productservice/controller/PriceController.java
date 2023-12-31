package com.productservice.controller;

import com.productservice.dto.PriceDTO;
import com.productservice.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

	@Autowired
    private PriceService priceService;

    public PriceController(PriceService priceService) {
		super();
		this.priceService = priceService;
	}

	@PostMapping
    public ResponseEntity<PriceDTO> createPrice(@RequestBody PriceDTO priceDTO) {
        PriceDTO createdPrice = priceService.createPrice(priceDTO);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PriceDTO>> getAllPrices() {
        List<PriceDTO> priceDTOList = priceService.getAllPrices();
        return new ResponseEntity<>(priceDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/{priceId}")
    public ResponseEntity<Object> getPriceById(@PathVariable Long priceId) {
        PriceDTO priceDTO = priceService.getPriceById(priceId);
        String errorMessage = "Price not found for id: " + priceId;
        return priceDTO != null
                ? new ResponseEntity<>(priceDTO, HttpStatus.OK)
                : new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
