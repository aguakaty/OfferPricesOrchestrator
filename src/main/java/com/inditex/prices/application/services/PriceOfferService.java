package com.inditex.prices.application.services;

import com.inditex.prices.domain.ports.in.GetPriceOfferUseCase;
import com.inditex.prices.infrastructure.mappers.PriceOfferResponseMapper;
import com.inditex.prices.infrastructure.records.PriceOfferResponse;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceOfferService {

    private final GetPriceOfferUseCase getPriceUseCase;
    private final PriceOfferResponseMapper priceOfferResponseMapper;

    public PriceOfferService(GetPriceOfferUseCase getPriceUseCase, PriceOfferResponseMapper priceOfferResponseMapper) {
        this.getPriceUseCase = getPriceUseCase;
        this.priceOfferResponseMapper = priceOfferResponseMapper;
    }

    public Optional<PriceOfferResponse> getOfferByDate(Long productId, Long brandId, LocalDateTime date) {
        return getPriceUseCase.getOfferByDate(productId,brandId,date)
                .map(priceOfferResponseMapper::priceOfferDomainToPriceOfferResponse);
    }
}
