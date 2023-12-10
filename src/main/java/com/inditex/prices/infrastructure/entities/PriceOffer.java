package com.inditex.prices.infrastructure.entities;

import com.inditex.prices.infrastructure.enums.Currency;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prices")
public class PriceOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "price_list")
    private Fee priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int priority;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Brand getBrand() {
        return brand;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Fee getPriceList() {
        return priceList;
    }

    public int getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Product getProduct() {
        return product;
    }
}
