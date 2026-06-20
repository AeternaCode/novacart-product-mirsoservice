package com.test.product_service.service.impl;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;
import com.test.product_service.error_handling.custom_exception.ResourceNotFoundException;
import com.test.product_service.mapper.product.ProductMapper;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import com.test.product_service.uttils.VerifyResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProduct{

    private final IProductRepo productRepo;
    private final VerifyResource verifyResource;

    @Override
    public List<GetProductResponseDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ProductMapper.toGetProductResponseDTO(products);
    }

    @Override
    public GetProductResponseDTO getProductById(Integer id){
        Product product = verifyResource.verifyOrGetProductById(id);
        return ProductMapper.toGetProductResponseDTO(product);
    }

    @Override
    public AddDeleteResponseDTO addProduct(AddProductRequestDTO addProductRequestDTO) {
        Category category = verifyResource.verifyOrGetCategoryById(addProductRequestDTO.categoryId());

        Product product = ProductMapper.toProductEntity(addProductRequestDTO, category);
        productRepo.save(product);
        return AddDeleteResponseDTO.builder().id(product.getId()).message("Product added successfully").build();
    }

    @Override
    public AddDeleteResponseDTO removeProductById(Integer id) {
        if(verifyResource.verifyOrGetProductById(id) != null) {
            productRepo.deleteById(id);
            return  AddDeleteResponseDTO.builder()
                    .id(null)
                    .message("Product removed successfully")
                    .build();
        }
        else throw new ResourceNotFoundException ("No Product Found with the given id : "+ id+ "Delete Unsuccessful", "PRODUCT_NOT_FOUND");
    }

    @Override
    public GetProductResponseDTO updateProductById(Integer id, UpdateProductRequestDTO updateProductRequestDTO) {
        Product product = verifyResource.verifyOrGetProductById(id);

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
            Category category = verifyResource.verifyOrGetCategoryById(updateProductRequestDTO.categoryId());
            product.setCategory(category);
        }
        productRepo.save(product);
        return ProductMapper.toGetProductResponseDTO(product);

    }

}
