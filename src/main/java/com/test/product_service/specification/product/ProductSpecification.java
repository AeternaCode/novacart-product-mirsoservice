package com.test.product_service.specification.product;

import com.test.product_service.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;

public final class ProductSpecification {

    private ProductSpecification() {}

    /** Insted of below ge use lambda expression and return directly.
     * Specification<Product> sep = new Specification<Product>() {
     *             public @Nullable Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
     *                 return null;
     *             }
     *         };
     *         or
     *         Specification<Product> spec = (root, query, criteriaBuilder) ->
     *                 criteriaBuilder.isNull(root.get("deletedAt"));
     * */

    public static Specification<Product> isNotDeleted(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isNull(root.get("deletedAt"));
    }

    public static Specification<Product> hasBrand(String brand){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("productBrand"), brand);
    }

    public static Specification<Product> hasCategory(Integer categoryId){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Product> hasMinimumPrice(BigDecimal minPrice){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> hasMaximumPrice(BigDecimal maxPrice){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> isInStock(boolean inStock){
            return(root, query, criteriaBuilder) ->
                    inStock ?
                            criteriaBuilder.greaterThan(root.get("stockQuantity"),0) // in stock product
                            :
                            criteriaBuilder.equal(root.get("stockQuantity"),0); // not in stock product
    }

    public static Specification<Product> hasProductName(String productName){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("productName")),
                        "%" + productName.toLowerCase() + "%");
    }

    public static Specification<Product> hasMinimumRating(BigDecimal minRating){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), minRating);
    }

    public static Specification<Product> hasActiveStatus(Boolean isActive){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isActive"), isActive);
    }
}
