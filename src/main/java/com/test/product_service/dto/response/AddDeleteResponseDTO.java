package com.test.product_service.dto.response;

import lombok.Builder;

@Builder
public record AddDeleteResponseDTO(
        Integer id,
        String message
) {
}
