package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.History;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryRepository extends JpaRepository<History, Long> {

}