package com.test.product_service.mapper.product;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;

import java.util.List;

public class ProductMapper {

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
                .map(ProductMapper::mapGetProductResponseDTO).toList();

    }

    public static GetProductResponseDTO toGetProductResponseDTO(Product product){
        return mapGetProductResponseDTO(product);
    }

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
