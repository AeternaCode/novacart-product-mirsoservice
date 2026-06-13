package com.test.product_service.mapper.product;

import com.test.product_service.dto.response.product.AddProductRequestDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;

public class ToEntity {

    public static Product toProductEntity(AddProductRequestDTO addProductRequestDTO) {
        Category category = new Category();
        category.setId(addProductRequestDTO.categoryId());
        return Product.builder()
                .productName(addProductRequestDTO.productName())
                .productImageUrl(addProductRequestDTO.productImageUrl())
                .productBrand(addProductRequestDTO.productBrand())
                .productDescription(addProductRequestDTO.productDescription())
                .price(addProductRequestDTO.price())
                .stockQuantity(addProductRequestDTO.stockQuantity())
                .isActive(addProductRequestDTO.isActive())
                .category(category)
                .build();
    }
}
