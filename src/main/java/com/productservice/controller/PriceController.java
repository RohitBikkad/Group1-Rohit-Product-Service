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
    
	@Autowired
	private ModelMapper modelMapper;

    public PriceController(PriceService priceService, ModelMapper modelMapper) {
        this.priceService = priceService;
        this.modelMapper = modelMapper;
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
    public ResponseEntity<PriceDTO> getPriceById(@PathVariable Long priceId) {
        PriceDTO priceDTO = priceService.getPriceById(priceId);
        return priceDTO != null
                ? new ResponseEntity<>(priceDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
