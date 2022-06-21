package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Dto.Shop.ProductSearchDto;
import com.TrollMarket.TrollMarket.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(String productName, String categoryName, String description);
    Page<Product> findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(String productName, String categoryName, String description, Pageable pageable);
}