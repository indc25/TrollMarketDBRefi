package com.TrollMarket.TrollMarket.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private final int id;
    private final String categoryName;
    private final String description;
}
