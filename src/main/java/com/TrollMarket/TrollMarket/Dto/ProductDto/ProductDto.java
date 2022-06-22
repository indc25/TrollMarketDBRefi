package com.TrollMarket.TrollMarket.Dto.ProductDto;

import com.TrollMarket.TrollMarket.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String productName;
    private String categoryId;
    private String description;
    private String unitPrice;
    private String discontinue;
    private String sellerId;

    public static List<ProductDto> toList(List<Product> products){
        List<ProductDto> result = new ArrayList<>();

        for(Product product : products){
            result.add(new ProductDto(
                    product.getId(),
                    product.getProductName(),
                    product.getCategoryID().getCategoryName(),
                    product.getDescription(),
                    product.getUnitPrice().toString(),
                    product.getDiscontinue() ? "Yes" : "No",
                    product.getSellerID().getFullName()));
        }
        return result;
    }
}
