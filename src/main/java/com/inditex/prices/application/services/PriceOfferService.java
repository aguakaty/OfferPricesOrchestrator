package com.inditex.prices.application.services;

import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.domain.ports.in.GetPriceOfferUseCase;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceOfferService implements GetPriceOfferUseCase {

    private final GetPriceOfferUseCase getPriceUseCase;

    public PriceOfferService(GetPriceOfferUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @Override
    public Optional<PriceOfferDomain> getOfferByDate(Long productId, Long brandId, LocalDateTime date) {
        return getPriceUseCase.getOfferByDate(productId,brandId,date);
    }
}
