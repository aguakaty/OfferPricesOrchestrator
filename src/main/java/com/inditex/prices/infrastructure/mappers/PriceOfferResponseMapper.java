package com.inditex.prices.infrastructure.mappers;

import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.infrastructure.records.PriceOfferResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceOfferResponseMapper {
    PriceOfferResponseMapper INSTANCE = Mappers.getMapper(PriceOfferResponseMapper.class);

    PriceOfferResponse priceOfferDomainToPriceOfferResponse(PriceOfferDomain priceOfferDomain);

}
