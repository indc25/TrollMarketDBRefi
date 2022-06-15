package com.TrollMarket.TrollMarket.Dto.Profile;

import com.TrollMarket.TrollMarket.Models.Balance;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProfileBalanceDto implements Serializable {
    private final Long id;
    private final String firstName;
    private final BigDecimal balance;

    public static ProfileBalanceDto set(Balance balance){
        return new ProfileBalanceDto(
                balance.getId(),
                balance.getProfile().getFirstName(),
                balance.getBalance()
        );
    }
}
