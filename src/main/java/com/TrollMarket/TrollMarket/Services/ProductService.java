package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.Shop.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductFeedBack;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductGridDto;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductSearchDto;
import com.TrollMarket.TrollMarket.Models.Product;
import com.TrollMarket.TrollMarket.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductGridDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return ProductGridDto.toList(productList);
    }

    public ProductDetailsDto findByIdProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
        return ProductDetailsDto.set(product);
    }

    private final int PAGE_SIZE = 5;
    public List<ProductDetailsDto> searchBy(ProductSearchDto productSearchDto) {

        Page<Product> productList = productRepository.findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(productSearchDto.getProductName(), productSearchDto.getCategoryName(), productSearchDto.getDescription(), PageRequest.of(productSearchDto.getPage() - 1, PAGE_SIZE, Sort.by("productName")));

        if (productList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        return ProductDetailsDto.toList(productList);
    }


    //------------------------BUAT API---------------------------
    public ProductFeedBack findBy(ProductSearchDto productSearchDto) {

        Page<Product> productPage = productRepository.findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(productSearchDto.getProductName(), productSearchDto.getCategoryName(), productSearchDto.getDescription(), PageRequest.of(productSearchDto.getPage() - 1, PAGE_SIZE, Sort.by("productName")));
        if (productPage.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return ProductFeedBack.toList(productPage, productSearchDto.getPage(), productSearchDto.getProductName(), productSearchDto.getCategoryName(), productSearchDto.getDescription());
    }
}
