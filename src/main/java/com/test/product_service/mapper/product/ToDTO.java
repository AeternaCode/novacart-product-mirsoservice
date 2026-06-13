package com.test.product_service.mapper.product;

import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Product;

import java.util.List;

public class ToDTO {

    private static GetProductResponseDTO mapGetProductResponseDTO(Product product){
       return GetProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productImageUrl(product.getProductImageUrl())
                .productBrand(product.getProductBrand())
                .rating(product.getRating())
                .productDescription(product.getProductDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .isActive(product.getIsActive())
                .createdBy(product.getCreatedBy())
                .updatedBy(product.getUpdatedBy())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getCategoryName())
                .build();
    }
    public static List<GetProductResponseDTO> toGetProductResponseDTO(List<Product> products){
        return products.stream()
                .map(ToDTO::mapGetProductResponseDTO).toList();

    }

    public static GetProductResponseDTO toGetProductResponseDTO(Product product){
        return mapGetProductResponseDTO(product);
    }


}
