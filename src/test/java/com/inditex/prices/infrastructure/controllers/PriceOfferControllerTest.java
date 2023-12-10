package com.inditex.prices.infrastructure.controllers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
class PriceOfferControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final LocalDateTime dia14hora10 = LocalDateTime.of(2020,6,14,10,0,0);
    private final LocalDateTime dia14hora16 = LocalDateTime.of(2020,6,14,16,0,0);
    private final LocalDateTime dia14hora21 = LocalDateTime.of(2020,6,14,21,0,0);
    private final LocalDateTime dia15hora10 = LocalDateTime.of(2020,6,15,10,0,0);
    private final LocalDateTime dia16hora21 = LocalDateTime.of(2020,6,16,21,0,0);

    @Test
    void getPriceInfoTest() throws Exception {
        executeGetPriceInfo(35455, 1, dia14hora10, 35.50);
        executeGetPriceInfo(35455, 1, dia14hora16, 25.45);
        executeGetPriceInfo(35455, 1, dia14hora21, 35.50);
        executeGetPriceInfo(35455, 1, dia15hora10, 30.50);
        executeGetPriceInfo(35455, 1, dia16hora21, 38.95);

        executeGetPriceInfoNotFound(35459, 1, dia16hora21);
    }

    void executeGetPriceInfo(int productId, int brandId, LocalDateTime date, double expectedPrice) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?date={date}&productId={productId}&brandId={brandId}", date, productId, brandId))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expectedPrice))
                .andDo(MockMvcResultHandlers.print());
    }
    void executeGetPriceInfoNotFound(int productId, int brandId, LocalDateTime date) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices?date={date}&productId={productId}&brandId={brandId}", date, productId, brandId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

}