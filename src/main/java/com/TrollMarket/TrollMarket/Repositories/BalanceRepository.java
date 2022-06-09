package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}