package com.TrollMarket.TrollMarket.Dto.PurchaseHistories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryPurcaseGridDto implements Serializable {
    private String historyDate;
    private String productName;
    private Integer quantity;
    private String shipVia;
    private Long totalPrice;


}
