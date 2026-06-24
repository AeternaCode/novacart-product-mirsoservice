package com.test.product_service.mapper.category;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public class CategoryMapper {

    private static GetCategoryResponseDTO mapGetProductResponseDTO(Category category){
        return GetCategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .createdBy(category.getCreatedBy())
                .updatedBy(category.getUpdatedBy())
                .isActive(category.getIsActive())
                .deletedAt(category.getDeletedAt())
                .build();
    }
    public static  GetCategoryResponseDTO toDTO(Category category) {
       return mapGetProductResponseDTO(category);
    }

    public static  List<GetCategoryResponseDTO> toDto(List<Category> category) {
        return category.stream()
                .map(CategoryMapper::mapGetProductResponseDTO)
                .toList();
    }

    public static  Category toEntity(AddUpdateCategoryRequestDTO getCategoryResponseDTO) {
        return Category.builder()
                .categoryName(getCategoryResponseDTO.categoryName())
                .build();
    }

    public static PageResponse<GetCategoryResponseDTO> toPageResponse(List<GetCategoryResponseDTO> listDto, Page<Category> page) {
        return PageResponse.<GetCategoryResponseDTO>builder() // to Explicitly tell the type otherwise it will throw error
                .content(listDto)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .numberOfElements(page.getNumberOfElements())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }
}
