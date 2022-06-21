package com.TrollMarket.TrollMarket.Dto.Shop;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductSearchDto implements Serializable {
    private String productName = "";
    private String categoryName = "";
    private String description ="";
    private Integer page = 1;
}
