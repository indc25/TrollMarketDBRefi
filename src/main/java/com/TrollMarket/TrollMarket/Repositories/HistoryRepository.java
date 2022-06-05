package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query(value = """
            select * from Histories where BuyerID Like Concat ('%',:buyerId,'%');
            """, nativeQuery = true)
    List<History> getBuyerId(@Param("buyerId") Long buyerId);
}