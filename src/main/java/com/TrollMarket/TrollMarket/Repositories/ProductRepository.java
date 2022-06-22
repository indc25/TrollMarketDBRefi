package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //find by containing productname, categoryName, description
    List<Product> findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(String productName, String categoryName, String description);
}