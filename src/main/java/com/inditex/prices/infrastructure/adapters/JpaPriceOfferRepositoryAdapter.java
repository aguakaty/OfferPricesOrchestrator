package com.inditex.prices.infrastructure.adapters;

import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.domain.ports.out.PriceOfferRepositoryPort;
import com.inditex.prices.infrastructure.mappers.PriceOfferMapper;
import com.inditex.prices.infrastructure.repositories.JpaPriceOfferRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class JpaPriceOfferRepositoryAdapter implements PriceOfferRepositoryPort {

    private final JpaPriceOfferRepository jpaPriceOfferRepository;

    private final PriceOfferMapper priceOfferMapper;

    public JpaPriceOfferRepositoryAdapter(JpaPriceOfferRepository jpaPriceOfferRepository, PriceOfferMapper priceOfferMapper) {
        this.jpaPriceOfferRepository = jpaPriceOfferRepository;
        this.priceOfferMapper = priceOfferMapper;
    }

    @Override
    public Optional<List<PriceOfferDomain>> getPricesByProductIdAndDate(Long productId, Long brandId, LocalDateTime date) {

        return jpaPriceOfferRepository
                .findByProductIdAndBrandId(productId, brandId)
                .map(priceOffers -> priceOffers
                        .stream()
                        .filter(offer -> offer.getStartDate().compareTo(date) <= 0 && offer.getEndDate().compareTo(date) >= 0)
                        .map(priceOfferMapper::priceOfferToPriceOfferDomain)
                        .toList());
    }
}
