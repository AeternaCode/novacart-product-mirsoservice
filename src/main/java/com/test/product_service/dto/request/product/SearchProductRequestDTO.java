package com.test.product_service.dto.request.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(
        name = "SearchProductRequestDTO",
        description = "Request parameters for searching and filtering products"
)
public record SearchProductRequestDTO(

        @Schema(
                description = "Filter products by name (partial or exact match, depending on implementation)",
                example = "iPhone"
        )
        String productName,

        @Schema(
                description = "Filter products by brand",
                example = "Apple"
        )
        String productBrand,

        @Schema(
                description = "Filter products by category ID",
                example = "1",
                minimum = "1"
        )
        Integer categoryId,

        @Schema(
                description = "Minimum product price",
                example = "1000.00",
                minimum = "0"
        )
        BigDecimal minPrice,

        @Schema(
                description = "Maximum product price",
                example = "100000.00",
                minimum = "0"
        )
        BigDecimal maxPrice,

        @Schema(
                description = "Minimum product rating",
                example = "4.0",
                minimum = "0",
                maximum = "5"
        )
        BigDecimal minRating,

        @Schema(
                description = "Filter products that are currently in stock",
                example = "true"
        )
        Boolean inStock,

        @Schema(
                description = "Filter products by active status",
                example = "true"
        )
        Boolean isActive

) {
}