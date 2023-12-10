package com.inditex.prices.infrastructure.config;

import com.inditex.prices.application.services.PriceOfferService;
import com.inditex.prices.application.usecases.GetPriceOfferUseCaseImp;
import com.inditex.prices.domain.ports.in.GetPriceOfferUseCase;
import com.inditex.prices.domain.ports.out.PriceOfferRepositoryPort;
import com.inditex.prices.infrastructure.adapters.JpaPriceOfferRepositoryAdapter;
import com.inditex.prices.infrastructure.mappers.PriceOfferMapper;
import com.inditex.prices.infrastructure.mappers.PriceOfferResponseMapper;
import com.inditex.prices.infrastructure.repositories.JpaPriceOfferRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PriceOfferService priceOfferService(PriceOfferRepositoryPort priceOfferRepositoryPort, GetPriceOfferUseCase getPriceOfferUseCase, PriceOfferResponseMapper priceOfferResponseMapper){
        return new PriceOfferService(new GetPriceOfferUseCaseImp(priceOfferRepositoryPort), priceOfferResponseMapper);
    }

    @Bean
    public PriceOfferRepositoryPort priceOfferRepositoryPort(JpaPriceOfferRepositoryAdapter jpaPriceOfferRepositoryAdapter){
        return jpaPriceOfferRepositoryAdapter;
    }

    @Bean
    public GetPriceOfferUseCase getPriceOfferUseCase(PriceOfferRepositoryPort priceOfferRepositoryPort){
        return new GetPriceOfferUseCaseImp(priceOfferRepositoryPort);
    }

    @Bean
    public JpaPriceOfferRepositoryAdapter jpaPriceOfferRepositoryAdapter(JpaPriceOfferRepository jpaPriceOfferRepository, PriceOfferMapper priceOfferMapper){
        return new JpaPriceOfferRepositoryAdapter(jpaPriceOfferRepository, priceOfferMapper);
    }

}
