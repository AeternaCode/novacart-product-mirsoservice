package com.test.product_service.dto.request.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Schema(description = "Request payload for Updating a product")
public record UpdateProductRequestDTO(

        @Size(min = 2, max = 100,
                message = "Product name must be between 2 and 100 characters")
        String productName,

        @Size(max = 500,
                message = "Product image URL cannot exceed 500 characters")
        String productImageUrl,

        @Size(max = 100,
                message = "Product brand cannot exceed 100 characters")
        String productBrand,

        @PositiveOrZero(message = "Rating cannot be negative")
        @DecimalMax(value = "5.0",
                message = "Rating cannot be greater than 5")
        BigDecimal rating,

        @Size(max = 2000,
                message = "Product description cannot exceed 2000 characters")
        String productDescription,

        @Positive(message = "Price must be greater than 0")
        @Digits(integer = 8, fraction = 2,
                message = "Price can have up to 8 digits and 2 decimal places")
        BigDecimal price,

        @PositiveOrZero(message = "Stock quantity cannot be negative")
        Integer stockQuantity,

        Boolean isActive,

        @Positive(message = "Category ID must be greater than 0")
        Integer categoryId
) {
}
