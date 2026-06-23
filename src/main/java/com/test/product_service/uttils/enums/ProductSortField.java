package com.test.product_service.uttils.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Available product sorting fields")
@Getter
public enum ProductSortField {
    ID("id"),
    PRICE("price"),
    NAME("productName"),
    RATING("rating"),
    CREATED_AT("createdAt");

    private final String productSortValue;

    ProductSortField(String productValue) {
        this.productSortValue = productValue;
    }
}
