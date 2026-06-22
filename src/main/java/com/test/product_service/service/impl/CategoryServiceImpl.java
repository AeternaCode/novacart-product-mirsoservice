package com.test.product_service.service.impl;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
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
    public PageResponse<GetCategoryResponseDTO> getAllCategories(int pageNumber, int size, CategorySortField sortBy, SortDirection direction) {
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
        return PageResponse.<GetCategoryResponseDTO>builder() // to Explicitly tell the type otherwise it will throw error
                .content(listDto)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .numberOfElements(page.getNumberOfElements())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }

    @Override
    public GetCategoryResponseDTO getCategoryById(Integer id) {
        Category category = verifyResource.verifyOrGetCategoryById(id);
        log.info("Successfully Get category with id : {}", category.getId());
        return CategoryMapper.toDTO(category);
    }

    @Override
    public AddDeleteResponseDTO addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO) {
        Category category = CategoryMapper.toEntity(addCategoryRequestDTO);
        log.info("Creating category: {}", addCategoryRequestDTO.categoryName());
       Category savedcategory =  categoryRepo.save(category);
        log.info("Category created successfully. ProductId={}", category.getId());
        return AddDeleteResponseDTO.builder()
                .id(savedcategory.getId())
                .message("Category Added Successfully with name : "+ savedcategory.getCategoryName())
                .build();
    }

    @Override
    public AddDeleteResponseDTO removeCategoryById(Integer id) {
        verifyResource.verifyOrGetCategoryById(id);
        log.info("Deleting category with id {}", id);
        categoryRepo.deleteById(id);
        return AddDeleteResponseDTO.builder()
                .id(null)
                .message("Category Removed Successfully")
                .build();
    }

    @Override
    public GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO) {
       Category category = verifyResource.verifyOrGetCategoryById(id);
        log.info("Updating category with id {}", id);
       if(updateCategoryRequestDTO.categoryName() != null && !updateCategoryRequestDTO.categoryName().isEmpty()){
           category.setCategoryName(updateCategoryRequestDTO.categoryName());
       }
       categoryRepo.save(category);
        log.info("Category updated successfully. CategoryId={}", category.getId());
       return CategoryMapper.toDTO(category);
    }

}
