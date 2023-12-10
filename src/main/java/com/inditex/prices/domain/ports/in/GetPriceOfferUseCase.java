package com.inditex.prices.domain.ports.in;

import com.inditex.prices.domain.model.PriceOfferDomain;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GetPriceOfferUseCase {
    Optional<PriceOfferDomain> getOfferByDate(Long productId, Long brandId, LocalDateTime date);
}
