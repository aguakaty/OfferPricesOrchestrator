package com.inditex.prices.infrastructure.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceOfferResponse (
        Long brandId,
        Long productId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal priceOffer,
        BigDecimal price
){
}
