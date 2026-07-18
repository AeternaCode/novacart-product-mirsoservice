package com.test.product_service.mapper.product;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;

import java.util.List;

public class ProductMapper {

    public static List<GetProductResponseDTO> toGetProductResponseDTO(List<Product> products){
        return products.stream()
                .map(ProductMapper::toGetProductResponseDTO).toList();

    }

    public static GetProductResponseDTO toGetProductResponseDTO(Product product){
        return new GetProductResponseDTO(
                product.getId(),
                product.getProductName(),
                product.getProductImageUrl(),
                product.getProductBrand(),
                product.getRating(),
                product.getProductDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getIsActive(),
                product.getCreatedBy(),
                product.getUpdatedBy(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getDeletedAt(),
                product.getCategory().getId(),
                product.getCategory().getCategoryName()
                );
    }

    public static Product updateProductFormDTO(UpdateProductRequestDTO updateProductRequestDTO, Product product){
        if(updateProductRequestDTO == null || product == null) {
            return product;
        }

        if(updateProductRequestDTO.productName() != null)
            product.setProductName(updateProductRequestDTO.productName());

        if(updateProductRequestDTO.productImageUrl() != null)
            product.setProductImageUrl(updateProductRequestDTO.productImageUrl());


        if(updateProductRequestDTO.productBrand() != null)
            product.setProductBrand(updateProductRequestDTO.productBrand());


        if(updateProductRequestDTO.productDescription() != null)
            product.setProductDescription(updateProductRequestDTO.productDescription());


        if(updateProductRequestDTO.price() != null)
            product.setPrice(updateProductRequestDTO.price());


        if(updateProductRequestDTO.stockQuantity() != null)
            product.setStockQuantity(updateProductRequestDTO.stockQuantity());


        if(updateProductRequestDTO.isActive() != null)
            product.setIsActive(updateProductRequestDTO.isActive());

        if (updateProductRequestDTO.rating() != null)
            product.setRating(updateProductRequestDTO.rating());

        return product;
    }

    public static Product toProductEntity(AddProductRequestDTO addProductRequestDTO, Category category) {

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
