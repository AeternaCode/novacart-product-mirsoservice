package com.test.product_service.dto.request.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SearchProductRequestDTO(

        String productName,

        String productBrand,

        Integer categoryId,

        BigDecimal minPrice,

        BigDecimal maxPrice,

        BigDecimal minRating,

        Boolean inStock,

        Boolean isActive
) {
}
