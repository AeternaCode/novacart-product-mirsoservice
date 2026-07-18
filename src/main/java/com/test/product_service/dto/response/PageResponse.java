package com.test.product_service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Schema(
        name = "PageResponse",
        description = "Paginated response containing the requested data and pagination metadata"
)
@Builder
public record PageResponse<T>(

        @Schema(
                description = "List of items in the current page"
        )
        List<T> content,

        @Schema(
                description = "Zero-based page number",
                example = "0"
        )
        int pageNumber,

        @Schema(
                description = "Maximum number of items per page",
                example = "10"
        )
        int pageSize,

        @Schema(
                description = "Total number of items across all pages",
                example = "125"
        )
        long totalElements,

        @Schema(
                description = "Total number of available pages",
                example = "13"
        )
        int totalPages,

        @Schema(
                description = "Number of items in the current page",
                example = "10"
        )
        int numberOfElements,

        @Schema(
                description = "Indicates whether this is the first page",
                example = "true"
        )
        boolean first,

        @Schema(
                description = "Indicates whether this is the last page",
                example = "false"
        )
        boolean last

) {
}