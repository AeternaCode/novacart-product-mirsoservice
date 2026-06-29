package com.test.product_service.dto.request.category;

import lombok.Builder;

@Builder
public record SearchCategoryRequestDTO(
        String categoryName,

        Boolean isActive
) {
}
