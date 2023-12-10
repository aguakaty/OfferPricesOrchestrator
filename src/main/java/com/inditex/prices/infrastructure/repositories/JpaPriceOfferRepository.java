package com.inditex.prices.infrastructure.repositories;

import com.inditex.prices.infrastructure.entities.PriceOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaPriceOfferRepository extends JpaRepository<PriceOffer, Long> {
    Optional<List<PriceOffer>> findByProductIdAndBrandId(Long productId, Long brandId);
}
