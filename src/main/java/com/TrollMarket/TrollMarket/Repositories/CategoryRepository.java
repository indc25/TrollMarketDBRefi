package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}