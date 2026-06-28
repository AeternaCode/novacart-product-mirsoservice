package com.test.product_service.service.impl;

import com.test.product_service.config.PaginationProperties;
import com.test.product_service.dto.ApiResponse;
import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.SearchProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;
import com.test.product_service.error_handling.custom_exception.ResourceNotFoundException;
import com.test.product_service.mapper.product.ProductMapper;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import com.test.product_service.specification.product.ProductSpecificationBuilder;
import com.test.product_service.uttils.VerifyResource;
import com.test.product_service.uttils.enums.ProductSortField;
import com.test.product_service.uttils.enums.SortDirection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import static com.test.product_service.mapper.product.ProductMapper.toGetProductResponseDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProduct{

    private final IProductRepo productRepo;
    private final VerifyResource verifyResource;
    private final PaginationProperties paginationProperties;

    @Override
    public ApiResponse<PageResponse<GetProductResponseDTO>> getAllProducts(SearchProductRequestDTO searchProductRequestDTO, int pageNumber, int size, ProductSortField sortBy, SortDirection direction) {

        // Creating Sort
        Sort sort = direction == SortDirection.DESC ?
                Sort.by(sortBy.getProductSortValue()).descending()
                :
                Sort.by(sortBy.getProductSortValue()).ascending();

        int pageSize =  Math.min(size, paginationProperties.maxPageSize());
        if(size < paginationProperties.defaultPageSize()) pageSize = paginationProperties.defaultPageSize();

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);

        Specification<Product> specification = ProductSpecificationBuilder.build(searchProductRequestDTO);

        Page<Product> page = productRepo.findAll(specification,pageable);
        List<Product> products = page.getContent(); // actual data

        List<GetProductResponseDTO> listDto =  ProductMapper.toGetProductResponseDTO(products);

        log.info("List of Products : {}", listDto);
        return ApiResponse.<PageResponse<GetProductResponseDTO>>builder()
                .success(true)
                .message("Product List fetched successfully")
                .data(ProductMapper.toPageResponse(listDto, page))
                .build();
    }

    @Override
    public ApiResponse<GetProductResponseDTO> getProductById(Integer id){
        Product product = verifyResource.verifyOrGetProductById(id);
        log.info("Successfully Get product with id : {}", product.getId());
        return ApiResponse.<GetProductResponseDTO>builder()
                .success(true)
                .message("Product fetched successfully with id : "+ product.getId())
                .data(toGetProductResponseDTO(product))
                .build();
    }

    @Override
    public ApiResponse<Integer> addProduct(AddProductRequestDTO addProductRequestDTO) {
        Category category = verifyResource.verifyOrGetCategoryById(addProductRequestDTO.categoryId());
        log.info("Creating product: {}", addProductRequestDTO.productName());
        Product product = ProductMapper.toProductEntity(addProductRequestDTO, category);
        productRepo.save(product);
        log.info("Product created successfully. ProductId={}", product.getId());
        return  ApiResponse.<Integer>builder()
                .success(true)
                .message("Product added successfully with id : " +  product.getId())
                .data(product.getId())
                .build();
    }

    @Override
    public ApiResponse<Integer> removeProductById(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("No Product Found with the given id :"+ id, "PRODUCT_NOT_FOUND"));
        log.info("Deleting product with id {}", id);
            productRepo.deleteById(id);
            return    ApiResponse.<Integer>builder()
                    .success(true)
                    .message("Product removed successfully with id : " +  product.getId())
                    .data(null)
                    .build();
    }

    @Override
    public ApiResponse<Integer> softRemoveProductById(Integer id) {
        Product product = verifyResource.verifyOrGetProductById(id);
        log.info("Soft Deleting product with id {}", id);
        product.setDeletedAt(LocalDateTime.now());
        product.setIsActive(false);

        productRepo.save(product);

        return    ApiResponse.<Integer>builder()
                .success(true)
                .message("Product removed successfully with id : " +  product.getId())
                .data(null)
                .build();
    }

    @Override
    public ApiResponse<Integer> restoreProductById(Integer id) {
        Product product = productRepo.findByIdAndDeletedAtIsNotNull(id)
                .orElseThrow(() -> new  ResourceNotFoundException ("No Product found with id : " + id,"PRODUCT_NOT_FOUND"));
        log.info("Restore product with id {}", id);
        product.setDeletedAt(null);
        product.setIsActive(true);

        productRepo.save(product);

        return    ApiResponse.<Integer>builder()
                .success(true)
                .message("Product restored successfully with id : " +  product.getId())
                .data(null)
                .build();
    }

    @Override
    public ApiResponse<GetProductResponseDTO> getDeletedProductById(Integer id) {
        Product product = productRepo.findByIdAndDeletedAtIsNotNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("No deleted Product Found with the given id :"+ id, "PRODUCT_NOT_FOUND"));

        log.info("Successfully Get deleted product with id : {}", product.getId());
        return ApiResponse.<GetProductResponseDTO>builder()
                .success(true)
                .message("Deleted Product fetched successfully with id : "+ product.getId())
                .data(toGetProductResponseDTO(product))
                .build();
    }

    @Override
    public ApiResponse<PageResponse<GetProductResponseDTO>> getDeletedProduct(int pageNumber, int size, ProductSortField sortBy, SortDirection direction) {
        // Creating Sort
        Sort sort = direction == SortDirection.DESC ?
                Sort.by(sortBy.getProductSortValue()).descending()
                :
                Sort.by(sortBy.getProductSortValue()).ascending();

        int pageSize =  Math.min(size, paginationProperties.maxPageSize());
        if(size < paginationProperties.defaultPageSize()) pageSize = paginationProperties.defaultPageSize();

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> page = productRepo.findAllByDeletedAtIsNotNull(pageable);
        List<Product> products = page.getContent(); // actual data

        List<GetProductResponseDTO> listDto =  ProductMapper.toGetProductResponseDTO(products);

        log.info("List of Products : {}", listDto);
        return ApiResponse.<PageResponse<GetProductResponseDTO>>builder()
                .success(true)
                .message("Deleted Product List fetched successfully")
                .data(ProductMapper.toPageResponse(listDto, page))
                .build();
    }

    @Override
    public ApiResponse<GetProductResponseDTO> updateProductById(Integer id, UpdateProductRequestDTO updateProductRequestDTO) {
        Product product = verifyResource.verifyOrGetProductById(id);

        log.info("Updating product with id {}", id);

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
        log.info("Product updated successfully. ProductId={}", product.getId());
        return   ApiResponse.<GetProductResponseDTO>builder()
                .success(true)
                .message("Product update successfully with id : " +  product.getId())
                .data(toGetProductResponseDTO(product))
                .build();

    }

}
