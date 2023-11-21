package com.productservice.service.impl;

import com.productservice.dto.PriceDTO;

import com.productservice.entities.Price;
import com.productservice.repository.PriceRepository;
import com.productservice.service.PriceService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
    private PriceRepository priceRepository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, ModelMapper modelMapper) {
        this.priceRepository = priceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PriceDTO createPrice(PriceDTO priceDTO) {
        Price price = modelMapper.map(priceDTO, Price.class);
        Price savedPrice = priceRepository.save(price);
        return modelMapper.map(savedPrice, PriceDTO.class);
    }

    @Override
    public PriceDTO getPriceById(Long priceId) {
        return priceRepository.findById(priceId)
                .map(price -> modelMapper.map(price, PriceDTO.class))
                .orElse(null);
    }

    @Override
    public List<PriceDTO> getAllPrices() {
        List<Price> prices = priceRepository.findAll();
        return prices.stream()
                .map(price -> modelMapper.map(price, PriceDTO.class))
                .collect(Collectors.toList());
    }

	@Override
	public PriceDTO getProductPrice(Long productVariantId) {
		// TODO Auto-generated method stub
		Optional<Price> priceOptional = priceRepository.findByproductVariantId(productVariantId);
		
		PriceDTO priceDTO = modelMapper.map(priceOptional.get(), PriceDTO.class);
        return priceDTO;
    }
	


}

