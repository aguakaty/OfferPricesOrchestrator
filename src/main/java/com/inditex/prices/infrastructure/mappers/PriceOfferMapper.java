package com.inditex.prices.infrastructure.mappers;

import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.infrastructure.entities.Brand;
import com.inditex.prices.infrastructure.entities.Fee;
import com.inditex.prices.infrastructure.entities.PriceOffer;
import com.inditex.prices.infrastructure.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface PriceOfferMapper {
    PriceOfferMapper INSTANCE = Mappers.getMapper(PriceOfferMapper.class);

    @Mapping(target = "priceOffer", source = "priceList")
    @Mapping(target = "brandId", source = "brand")
    @Mapping(target = "productId", source = "product")
    PriceOfferDomain priceOfferToPriceOfferDomain(PriceOffer priceOffer);

    default BigDecimal mapFee(Fee fee) {
        return fee != null ? fee.getFee() : null;
    }
    default Long mapProduct(Product product){
        return product.getId();
    }
    default Long mapBrand(Brand brand){
        return brand.getId();
    }
}
