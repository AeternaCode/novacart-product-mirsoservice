package com.test.product_service.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddUpdateCategoryRequestDTO(
        @NotBlank(message = "Category name is required")
        @Size(min = 2, max = 50,
                message = "Category name must be between 2 and 100 characters")
        String categoryName
) {
}
