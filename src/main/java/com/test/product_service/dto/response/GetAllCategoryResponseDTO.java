package com.test.product_service.dto.response;

import lombok.Builder;

@Builder
public record GetAllCategoryResponseDTO(
        int id,
        String categoryName
)
{}
