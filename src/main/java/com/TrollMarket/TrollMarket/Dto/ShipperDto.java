package com.TrollMarket.TrollMarket.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipperDto implements Serializable {
    private  Integer id;
    private String companyName;
    private String price;
    private String enabled;
}
