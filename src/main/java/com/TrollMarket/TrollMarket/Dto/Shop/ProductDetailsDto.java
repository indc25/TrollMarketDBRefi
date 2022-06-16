package com.TrollMarket.TrollMarket.Dto.Shop;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductDetailsDto implements Serializable {
    private final String productName;
    private final String categoryName;
    private final String description;
    private final BigDecimal unitPrice;
    private final String sellerName;

    public static ProductDetailsDto set(Product product) {
        return new ProductDetailsDto(
                product.getProductName(),
                product.getCategoryID().getCategoryName(),
                product.getDescription(),
                product.getUnitPrice(),
                product.getSellerID().getFullName()
        );
    }
}
