package com.test.product_service.uttils.enums;

import lombok.Getter;

@Getter
public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    private final String direction;

    SortDirection(String direction) {
        this.direction = direction;
    }

}
