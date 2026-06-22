package com.test.product_service.service.impl;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;
import com.test.product_service.mapper.product.ProductMapper;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import com.test.product_service.uttils.VerifyResource;
import com.test.product_service.uttils.enums.ProductSortField;
import com.test.product_service.uttils.enums.SortDirection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

import static com.test.product_service.mapper.product.ProductMapper.toGetProductResponseDTO;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProduct{

    private final IProductRepo productRepo;
    private final VerifyResource verifyResource;

    @Override
    public PageResponse<GetProductResponseDTO> getAllProducts(int pageNumber, int size, ProductSortField sortBy, SortDirection direction) {

        // Creating Sort
        Sort sort = direction == SortDirection.DESC ?
                Sort.by(sortBy.getProductSortValue()).descending()
                :
                Sort.by(sortBy.getProductSortValue()).ascending();

        Pageable pageable = PageRequest.of(pageNumber,size,sort);
        Page<Product> page = productRepo.findAll(pageable);
        List<Product> products = page.getContent(); // actual data

        List<GetProductResponseDTO> listDto =  ProductMapper.toGetProductResponseDTO(products);

        return PageResponse.<GetProductResponseDTO>builder() // to Explicitly tell the type otherwise it will throw error
                .content(listDto)
                .pageNumber(pageNumber)
                .pageSize(size)
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .numberOfElements(page.getNumberOfElements())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }

    @Override
    public GetProductResponseDTO getProductById(Integer id){
        Product product = verifyResource.verifyOrGetProductById(id);
        return toGetProductResponseDTO(product);
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
        verifyResource.verifyOrGetProductById(id);
            productRepo.deleteById(id);
            return  AddDeleteResponseDTO.builder()
                    .id(null)
                    .message("Product removed successfully")
                    .build();
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
        return toGetProductResponseDTO(product);

    }

}
