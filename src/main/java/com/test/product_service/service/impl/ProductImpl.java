package com.test.product_service.service.impl;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;
import com.test.product_service.mapper.product.ProductMapper;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements IProduct{

    private final IProductRepo productRepo;
    private final ICategoryRepo categoryRepo;

    @Override
    public List<GetProductResponseDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ProductMapper.toGetProductResponseDTO(products);
    }

    @Override
    public GetProductResponseDTO getProductById(Integer id){
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product Found"));
        return ProductMapper.toGetProductResponseDTO(product);
    }

    @Override
    public void addProduct(AddProductRequestDTO addProductRequestDTO) {
        Product product = ProductMapper.toProductEntity(addProductRequestDTO);
        productRepo.save(product);
    }

    @Override
    public void removeProductById(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public GetProductResponseDTO updateProductById(Integer id, UpdateProductRequestDTO updateProductRequestDTO) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product Found"));

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

        if(updateProductRequestDTO.categoryId() != null){
            Category category = categoryRepo.findById(
                            updateProductRequestDTO.categoryId())
                    .orElseThrow(() ->
                            new RuntimeException("Category not found"));

            product.setCategory(category);
        }
        productRepo.save(product);
        return ProductMapper.toGetProductResponseDTO(product);

    }
}
