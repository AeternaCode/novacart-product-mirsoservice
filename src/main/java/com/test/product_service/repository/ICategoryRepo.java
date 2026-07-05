package com.test.product_service.repository;

import com.test.product_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ICategoryRepo extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    Optional<Category> findByIdAndDeletedAtIsNull(Integer id);
    Optional<Category> findByIdAndDeletedAtIsNotNull(Integer id);
    boolean existsByCategoryNameIgnoreCaseAndDeletedAtIsNull(String categoryName);
    boolean existsByCategoryNameIgnoreCaseAndIdNotAndDeletedAtIsNull(String categoryName, Integer id);
}
