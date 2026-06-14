package com.test.product_service.dto.request.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AddProductRequestDTO(

        @NotBlank(message = "Product name is required")
        @Size(min = 2, max = 100,
                message = "Product name must be between 2 and 100 characters")
        String productName,

        @Size(max = 500,
                message = "Product image URL cannot exceed 500 characters")
        String productImageUrl,

        @Size(max = 100,
                message = "Product brand cannot exceed 100 characters")
        String productBrand,

        @Size(max = 2000,
                message = "Product description cannot exceed 2000 characters")
        String productDescription,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than 0")
        @Digits(integer = 8, fraction = 2,
                message = "Price can have up to 8 digits and 2 decimal places")
        BigDecimal price,

        @NotNull(message = "Stock quantity is required")
        @PositiveOrZero(message = "Stock quantity cannot be negative")
        Integer stockQuantity,

        @NotNull(message = "Product active status is required")
        Boolean isActive,

        @NotNull(message = "Category ID is required")
        @Positive(message = "Category ID must be greater than 0")
        Integer categoryId

        ) {
}
