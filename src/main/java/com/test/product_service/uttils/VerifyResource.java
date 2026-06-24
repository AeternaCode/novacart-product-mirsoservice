package com.test.product_service.uttils;

import com.test.product_service.entity.Category;
import com.test.product_service.entity.Product;
import com.test.product_service.error_handling.custom_exception.ResourceNotFoundException;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.repository.IProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VerifyResource {

    private final ICategoryRepo categoryRepo;
    private final IProductRepo productRepo;

    public Product verifyOrGetProductById(Integer id){
        log.info("Verifying product with id={}", id);
        return  productRepo.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Product Found with the given id :"+ id, "PRODUCT_NOT_FOUND"));
    }

    public Category verifyOrGetCategoryById(Integer id){
        log.info("Verifying category with id={}", id);
         return categoryRepo.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException ("No Category Found  with the given id : "+ id,"CATEGORY_NOT_FOUND"));

    }
}
