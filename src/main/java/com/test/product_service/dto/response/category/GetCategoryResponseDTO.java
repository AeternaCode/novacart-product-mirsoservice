package com.test.product_service.dto.response.category;

import lombok.Builder;

@Builder
public record GetCategoryResponseDTO(
        int id,
        String categoryName
)
{}
