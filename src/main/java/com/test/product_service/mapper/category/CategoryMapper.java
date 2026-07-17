package com.test.product_service.mapper.category;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;

import java.util.List;

public class CategoryMapper {

    public static  GetCategoryResponseDTO toDTO(Category category) {
        return new GetCategoryResponseDTO(
                category.getId(),
                category.getCategoryName(),
                category.getCreatedAt(),
                category.getUpdatedAt(),
                category.getCreatedBy(),
                category.getUpdatedBy(),
                category.getIsActive(),
                category.getDeletedAt()
                );
    }

    public static  List<GetCategoryResponseDTO> toDTO(List<Category> category) {
        return category.stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    public static  Category toEntity(AddUpdateCategoryRequestDTO getCategoryResponseDTO) {
        return Category.builder()
                .categoryName(getCategoryResponseDTO.categoryName())
                .build();
    }


}
