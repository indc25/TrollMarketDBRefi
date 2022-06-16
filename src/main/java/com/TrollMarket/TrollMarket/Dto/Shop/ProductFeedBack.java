package com.TrollMarket.TrollMarket.Dto.Shop;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductFeedBack implements Serializable {
    private final Integer totalPages;
    private final Integer page;
    private final String productName;
    private final String categoryName;
    private final String description;
    private final ProductDetailsDto[] products;

    public static ProductFeedBack toList(Page<Product> productPage,Integer page, String productName, String categoryName, String description) {
        return new ProductFeedBack(
                productPage.getTotalPages(),
                page,
                productName,
                categoryName,
                description,
                ProductDetailsDto.pageToList(productPage.getContent())
        );
    }

}
