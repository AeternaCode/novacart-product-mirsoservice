package com.test.product_service.service.impl;

import com.test.product_service.dto.response.GetAllProductResponseDTO;
import com.test.product_service.entity.Product;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements IProduct{

    private final IProductRepo productRepo;

    @Override
    public List<GetAllProductResponseDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map( product -> GetAllProductResponseDTO.builder()
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
                        .build()
                ).toList();
    }
}
