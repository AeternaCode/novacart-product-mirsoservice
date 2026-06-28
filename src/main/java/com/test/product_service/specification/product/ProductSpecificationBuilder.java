package com.test.product_service.specification.product;

import com.test.product_service.dto.request.product.SearchProductRequestDTO;
import com.test.product_service.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecificationBuilder {

    private ProductSpecificationBuilder() {}

    public static Specification<Product> build(SearchProductRequestDTO searchProductRequestDTO) {

        Specification<Product> specification = Specification.where(
                        ProductSpecification.isNotDeleted()
                );

        if(searchProductRequestDTO.productBrand() != null){
            specification = specification.and(
                    ProductSpecification.hasBrand(
                            searchProductRequestDTO.productBrand()
                    )
            );
        }
        if(searchProductRequestDTO.productName() != null){
            specification = specification.and(
                    ProductSpecification.hasProductName(
                            searchProductRequestDTO.productName())
            );
        }
        if (searchProductRequestDTO.inStock() != null){
            specification = specification.and(
                    ProductSpecification.isInStock(
                            searchProductRequestDTO.inStock()
                    )
            );
        }
        if (searchProductRequestDTO.isActive() != null){
            specification = specification.and(
                    ProductSpecification.hasActiveStatus(
                            searchProductRequestDTO.isActive()
                    )
            );
        }
        if(searchProductRequestDTO.minRating() != null){
            specification = specification.and(
                    ProductSpecification.hasMinimumRating(
                            searchProductRequestDTO.minRating())
            );
        }

        if(searchProductRequestDTO.minPrice() != null){
            specification = specification.and(
                    ProductSpecification.hasMinimumPrice(
                            searchProductRequestDTO.minPrice())
            );
        }
        if(searchProductRequestDTO.maxPrice() != null){
            specification = specification.and(
                    ProductSpecification.hasMaximumPrice(
                            searchProductRequestDTO.maxPrice()
                    )
            );
        }

        if(searchProductRequestDTO.categoryId() != null){
            specification = specification.and(
                    ProductSpecification.hasCategory(
                            searchProductRequestDTO.categoryId()
                    ));
        }

        return specification;
    }
}
