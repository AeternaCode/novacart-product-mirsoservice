package com.test.product_service.service.impl;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.mapper.category.CategoryMapper;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.service.ICategory;
import com.test.product_service.uttils.VerifyResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategory {

    private final ICategoryRepo categoryRepo;
    private final VerifyResource verifyResource;

    @Override
    public List<GetCategoryResponseDTO> getAllCategories() {
        List<Category> category = categoryRepo.findAll();
        return CategoryMapper.toDto(category);
    }

    @Override
    public GetCategoryResponseDTO getCategoryById(Integer id) {
        Category category = verifyResource.verifyOrGetCategoryById(id);
        return CategoryMapper.toDTO(category);
    }

    @Override
    public AddDeleteResponseDTO addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO) {
        Category category = CategoryMapper.toEntity(addCategoryRequestDTO);
       Category savedcategory =  categoryRepo.save(category);
        return AddDeleteResponseDTO.builder()
                .id(savedcategory.getId())
                .message("Category Added Successfully with name : "+ savedcategory.getCategoryName())
                .build();
    }

    @Override
    public AddDeleteResponseDTO removeCategoryById(Integer id) {
        verifyResource.verifyOrGetCategoryById(id);
        categoryRepo.deleteById(id);
        return AddDeleteResponseDTO.builder()
                .id(null)
                .message("Category Removed Successfully")
                .build();
    }

    @Override
    public GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO) {
       Category category = verifyResource.verifyOrGetCategoryById(id);
       if(updateCategoryRequestDTO.name() != null && !updateCategoryRequestDTO.name().isEmpty()){
           category.setCategoryName(updateCategoryRequestDTO.name());
       }
       categoryRepo.save(category);
       return CategoryMapper.toDTO(category);
    }

}
