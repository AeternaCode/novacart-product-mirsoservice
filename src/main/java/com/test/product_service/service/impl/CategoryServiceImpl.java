package com.test.product_service.service.impl;

import com.test.product_service.dto.ApiResponse;
import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.mapper.category.CategoryMapper;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.service.ICategory;
import com.test.product_service.uttils.VerifyResource;
import com.test.product_service.uttils.enums.CategorySortField;
import com.test.product_service.uttils.enums.SortDirection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategory {

    private final ICategoryRepo categoryRepo;
    private final VerifyResource verifyResource;

    @Override
    public ApiResponse<PageResponse<GetCategoryResponseDTO>> getAllCategories(int pageNumber, int size, CategorySortField sortBy, SortDirection direction) {
        // Creating Sort
        Sort sort = direction == SortDirection.DESC ?
                Sort.by(sortBy.getCategorySortValue()).descending()
                :
                Sort.by(sortBy.getCategorySortValue()).ascending();

        Pageable pageable = PageRequest.of(pageNumber,size, sort);
        Page<Category> page = categoryRepo.findAll(pageable);
        List<Category> category = page.getContent();

        List<GetCategoryResponseDTO> listDto = CategoryMapper.toDto(category);

        log.info("List of Category : {}", listDto);

         return ApiResponse.<PageResponse<GetCategoryResponseDTO>>builder()
                 .success(true)
                 .message("Category List fetched successfully")
                 .data(CategoryMapper.toPageResponse(listDto, page))
                 .build();
    }

    @Override
    public ApiResponse<GetCategoryResponseDTO> getCategoryById(Integer id) {
        Category category = verifyResource.verifyOrGetCategoryById(id);
        log.info("Successfully Get category with id : {}", category.getId());

        return ApiResponse.<GetCategoryResponseDTO>builder()
                .success(true)
                .message("Category with id : " + category.getId() +" fetched successfully")
                .data(CategoryMapper.toDTO(category))
                .build();
    }

    @Override
    public ApiResponse<Integer> addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO) {
        Category category = CategoryMapper.toEntity(addCategoryRequestDTO);
        log.info("Creating category: {}", addCategoryRequestDTO.categoryName());
       Category savedcategory =  categoryRepo.save(category);
        log.info("Category created successfully. ProductId={}", category.getId());

        return ApiResponse.<Integer>builder()
                .success(true)
                .message("Category Added Successfully with name : "+ savedcategory.getCategoryName())
                .data(savedcategory.getId())
                .build();
    }

    @Override
    public ApiResponse<Integer> removeCategoryById(Integer id) {
        verifyResource.verifyOrGetCategoryById(id);
        log.info("Deleting category with id {}", id);
        categoryRepo.deleteById(id);

        return ApiResponse.<Integer>builder()
                .success(true)
                .message("Category Removed Successfully with id : "+ id)
                .data(null)
                .build();
    }

    @Override
    public ApiResponse<GetCategoryResponseDTO> updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO) {
       Category category = verifyResource.verifyOrGetCategoryById(id);
        log.info("Updating category with id {}", id);
       if(updateCategoryRequestDTO.categoryName() != null && !updateCategoryRequestDTO.categoryName().isEmpty()){
           category.setCategoryName(updateCategoryRequestDTO.categoryName());
       }
       categoryRepo.save(category);
        log.info("Category updated successfully. CategoryId={}", category.getId());
        return ApiResponse.<GetCategoryResponseDTO>builder()
                .success(true)
                .message("Category Removed Successfully with id : "+ id)
                .data(CategoryMapper.toDTO(category))
                .build();
    }

}
