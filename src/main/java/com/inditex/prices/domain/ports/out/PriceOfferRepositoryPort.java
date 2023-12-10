package com.inditex.prices.domain.ports.out;

import com.inditex.prices.domain.model.PriceOfferDomain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceOfferRepositoryPort {
    Optional<List<PriceOfferDomain>> getPricesByProductIdAndDate(Long productId, Long brandId, LocalDateTime date);
}
