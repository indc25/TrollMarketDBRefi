package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.Shop.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductGridDto;
import com.TrollMarket.TrollMarket.Models.Product;
import com.TrollMarket.TrollMarket.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
