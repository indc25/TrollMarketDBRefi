package com.TrollMarket.TrollMarket.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileAddBalanceDto {
    private Long id;
    private BigDecimal balance;
}
