package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Cart;
import com.TrollMarket.TrollMarket.Models.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}