package com.inditex.prices.infrastructure.controllers;

import com.inditex.prices.application.services.PriceOfferService;
import com.inditex.prices.domain.model.PriceOfferDomain;
import com.inditex.prices.infrastructure.records.PriceOfferResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("api/prices")
public class PriceOfferController {
    private static final Logger logger = LoggerFactory.getLogger(PriceOfferController.class);
    private final PriceOfferService priceOfferService;

    public PriceOfferController(PriceOfferService priceOfferService) {
        this.priceOfferService = priceOfferService;
    }

    @GetMapping(name = "/")
    public ResponseEntity<?> getPriceInfo(@RequestParam LocalDateTime date,
                                                         @RequestParam int productId,
                                                         @RequestParam int brandId){
        logger.info("Received request for product={}, brand={}, date={}", productId, brandId, date);
        try{
            Optional<PriceOfferResponse> priceOffer = priceOfferService.getOfferByDate((long)productId, (long)brandId, date);
            if(priceOffer.isPresent()){
                logger.info("Price offer found: {}", priceOffer.get());
                return new ResponseEntity<>(priceOffer, HttpStatus.FOUND);
            }
            logger.warn("Price offer not found for product={}, brand={}, date={}", productId, brandId, date);
            return new ResponseEntity<>("Price offer not found.", HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            logger.error("An error occurred for product={}, brand={}, date={}", productId, brandId, date, ex);
            return new ResponseEntity<>("Internal Server Error \uD83E\uDED6", HttpStatus.I_AM_A_TEAPOT);
        }

    }
}
