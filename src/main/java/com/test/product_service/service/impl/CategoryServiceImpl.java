package com.test.product_service.service.impl;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;
import com.test.product_service.error_handling.custom_exception.CategoryNotFoundException;
import com.test.product_service.mapper.category.CategoryMapper;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.service.ICategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategory {

    private final ICategoryRepo categoryRepo;

    @Override
    public List<GetCategoryResponseDTO> getAllCategories() {
        List<Category> category = categoryRepo.findAll();
        return CategoryMapper.toDto(category);
    }

    @Override
    public GetCategoryResponseDTO getCategoryById(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("No Category Found  with the given id : "+ id));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public void addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO) {
        Category category = CategoryMapper.toEntity(addCategoryRequestDTO);
        categoryRepo.save(category);
    }

    @Override
    public void removeCategoryById(Integer id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO) {
       Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Category Found"));
       if(updateCategoryRequestDTO.name() != null && !updateCategoryRequestDTO.name().isEmpty()){
           category.setCategoryName(updateCategoryRequestDTO.name());
       }
       categoryRepo.save(category);
       return CategoryMapper.toDTO(category);
    }

}
