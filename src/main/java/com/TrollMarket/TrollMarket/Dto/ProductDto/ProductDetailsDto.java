package com.TrollMarket.TrollMarket.Dto.ProductDto;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Data
public class ProductDetailsDto implements Serializable {
    private final String productName;
    private final String categoryName;
    private final String description;
    private final String unitPrice;
    private final String sellerName;



    public static ProductDetailsDto set(Product product) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return new ProductDetailsDto(
                product.getProductName(),
                product.getCategoryID().getCategoryName(),
                product.getDescription(),
                currencyInstance.format(product.getUnitPrice()),
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