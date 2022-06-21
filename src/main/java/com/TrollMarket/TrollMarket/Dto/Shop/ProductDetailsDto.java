package com.TrollMarket.TrollMarket.Dto.Shop;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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

    public static List<ProductDetailsDto> toList(Page<Product> productList) {
        return productList.stream()
                .map(ProductDetailsDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public static ProductDetailsDto[] pageToList(List<Product> content) {
        return content.stream()
                .map(ProductDetailsDto::set)
                .toArray(ProductDetailsDto[]::new);
    }
}
