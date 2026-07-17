package com.test.product_service.dto.request.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(
        name = "SearchCategoryRequestDTO",
        description = "Request parameters for searching and filtering categories"
)
public record SearchCategoryRequestDTO(

        @Schema(
                description = "Filter categories by name (partial or exact match, depending on implementation)",
                example = "Electronics"
        )
        String categoryName,


        @Schema(
                description = "Filter categories by active status",
                example = "true"
        )
        Boolean isActive
) {
}
