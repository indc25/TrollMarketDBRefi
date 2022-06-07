package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}