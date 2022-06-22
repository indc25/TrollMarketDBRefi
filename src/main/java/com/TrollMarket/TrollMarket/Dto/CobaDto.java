package com.TrollMarket.TrollMarket.Dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CobaDto implements Serializable {
    private final Long id;
    private final String productName;
    private final String categoryName;
    private final String description;
    private final BigDecimal unitPrice;
    private final Boolean disco;
}
