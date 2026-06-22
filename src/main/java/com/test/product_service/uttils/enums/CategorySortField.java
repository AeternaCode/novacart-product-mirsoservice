package com.test.product_service.uttils.enums;

import lombok.Getter;

@Getter
public enum CategorySortField {
    ID("id"),
    NAME("categoryName");

    private final String categorySortValue;
    CategorySortField(String categorySortValue) {
        this.categorySortValue = categorySortValue;
    }
}
