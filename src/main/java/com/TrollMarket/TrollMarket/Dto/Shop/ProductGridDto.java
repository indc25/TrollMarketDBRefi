package com.TrollMarket.TrollMarket.Dto.Shop;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductGridDto implements Serializable {
    private final Long id;
    private final String productName;
    private final BigDecimal unitPrice;

    public static List<ProductGridDto> toList(List<Product> productList) {
        return productList.stream()
                .map(ProductGridDto::SET)
                .collect(java.util.stream.Collectors.toList());
    }

    private static ProductGridDto SET(Product product) {
        return new ProductGridDto(
                product.getId(),
                product.getProductName(),
                product.getUnitPrice());
    }
}
