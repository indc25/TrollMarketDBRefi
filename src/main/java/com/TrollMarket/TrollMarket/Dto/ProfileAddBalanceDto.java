package com.TrollMarket.TrollMarket.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProfileAddBalanceDto {
    private Long id;
    private BigDecimal balance;

    public ProfileAddBalanceDto(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }
}
