package com.test.product_service.repository;

import com.test.product_service.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

    Page<Category> findAllByDeletedAtIsNull(Pageable pageable);
    Page<Category> findAllByDeletedAtIsNotNull(Pageable pageable);
    Optional<Category> findByIdAndDeletedAtIsNull(Integer id);
    Optional<Category> findByIdAndDeletedAtIsNotNull(Integer id);
}
