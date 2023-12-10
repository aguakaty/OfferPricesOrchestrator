package com.inditex.prices.application.usecases;

import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.domain.ports.in.GetPriceOfferUseCase;
import com.inditex.prices.domain.ports.out.PriceOfferRepositoryPort;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class GetPriceOfferUseCaseImp implements GetPriceOfferUseCase {

    private final PriceOfferRepositoryPort priceRepositoryPort;

    public GetPriceOfferUseCaseImp(PriceOfferRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<PriceOfferDomain> getOfferByDate(Long productId, Long brandId, LocalDateTime date) {
        return priceRepositoryPort.getPricesByProductIdAndDate(productId, brandId, date)
                .orElse(Collections.emptyList())
                .stream()
                .max(Comparator.comparingInt(PriceOfferDomain::getPriority));
    }
}
