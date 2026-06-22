package com.test.product_service.uttils.enums;

import lombok.Getter;

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
