package com.test.product_service.specification.category;

import com.test.product_service.entity.Category;
import org.springframework.data.jpa.domain.Specification;

public final class CategorySpecification {
    private CategorySpecification() {}

    public static Specification<Category> isDeleted(){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.isNotNull(root.get("deletedAt"));
    }

    public static Specification<Category> isNotDeleted(){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.isNull(root.get("deletedAt"));
    }

    public static Specification<Category> hasCategoryName(String categoryName){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("categoryName")),
                        "%" + categoryName.toLowerCase() + "%");
    }

    public static Specification<Category> hasActiveStatus(Boolean isActive){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isActive"), isActive);

    }

}
