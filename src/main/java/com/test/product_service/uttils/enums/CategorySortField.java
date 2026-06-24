package com.test.product_service.uttils.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Available product sorting fields")
@Getter
public enum CategorySortField {
    ID("id"),
    NAME("categoryName"),
    CREATED_AT("createdAt");

    private final String categorySortValue;
    CategorySortField(String categorySortValue) {
        this.categorySortValue = categorySortValue;
    }
}
