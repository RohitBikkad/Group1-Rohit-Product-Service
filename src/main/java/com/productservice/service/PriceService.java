package com.productservice.service;

import com.productservice.dto.PriceDTO;
import java.util.List;

public interface PriceService {

    PriceDTO createPrice(PriceDTO priceDTO);

    PriceDTO getPriceById(Long priceId);

    List<PriceDTO> getAllPrices();

	PriceDTO getProductPrice(Long productVariantId);

    
}
