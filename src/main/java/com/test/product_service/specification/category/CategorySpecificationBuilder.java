package com.test.product_service.specification.category;

import com.test.product_service.dto.request.category.SearchCategoryRequestDTO;
import com.test.product_service.entity.Category;
import org.springframework.data.jpa.domain.Specification;

public final class CategorySpecificationBuilder {
    private CategorySpecificationBuilder() {}

    public static Specification<Category> buildActive(SearchCategoryRequestDTO searchCategoryRequestDTO) {
        return applyCommonFilters(
                Specification.where(CategorySpecification.isNotDeleted()),
                searchCategoryRequestDTO
        );
    }

    public static Specification<Category> buildDeleted(SearchCategoryRequestDTO searchCategoryRequestDTO) {
        return applyCommonFilters(
                Specification.where(CategorySpecification.isDeleted()),
                searchCategoryRequestDTO
        );
    }

    public static Specification<Category> applyCommonFilters(Specification<Category> specification, SearchCategoryRequestDTO searchCategoryRequestDTO){
        if(searchCategoryRequestDTO.categoryName() != null  && !searchCategoryRequestDTO.categoryName().isBlank()){
            specification = specification.and(
                    CategorySpecification.hasCategoryName(
                            searchCategoryRequestDTO.categoryName())
            );
        }

        if (searchCategoryRequestDTO.isActive() != null) {
            specification = specification.and(
                    CategorySpecification.hasActiveStatus(
                            searchCategoryRequestDTO.isActive())
            );
        }

        return specification;
    }
}
