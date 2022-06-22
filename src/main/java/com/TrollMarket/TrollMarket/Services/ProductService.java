package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.ProductDto.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Dto.ProductDto.ProductDto;
import com.TrollMarket.TrollMarket.Models.Product;
import com.TrollMarket.TrollMarket.Repositories.ProductRepository;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import com.TrollMarket.TrollMarket.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Service
public class ProductService {

    private final ProfileRepository profileRepositories;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    @Autowired
    public ProductService(ProfileRepository profileRepositories, UserRepository userRepository, ProductRepository productRepository) {
        this.profileRepositories = profileRepositories;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductDto -> new ProductDto(
                        ProductDto.getId(),
                        ProductDto.getProductName(),
                        ProductDto.getCategoryID().getCategoryName(),
                        ProductDto.getDescription(),
                        currencyInstance.format(ProductDto.getUnitPrice()),
                        ProductDto.getDiscontinue() ? "Yes" : "No",
                        ProductDto.getSellerID().getFullName()
                ))
                .collect(java.util.stream.Collectors.toList());
    }


    public ProductDto findProduct() {

        Product product = productRepository.getById(1L);
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getCategoryID().getCategoryName(),
                product.getDescription(),
                currencyInstance.format(product.getUnitPrice()),
                product.getDiscontinue() ? "Yes" : "No",
                product.getSellerID().getFullName()
        );
    }

    public void discontinue (Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        if (product.getDiscontinue() == false) {
            product.setDiscontinue(true);
        } else {
            product.setDiscontinue(false);
        }
        productRepository.save(product);
    }

    public List<ProductDto> getAllProduct(String productName, String categoryName, String description) {
        List<Product> productList =
                productRepository.findByProductNameContainingAndCategoryID_CategoryNameContainingAndDescriptionContaining(productName, categoryName, description);
        List<ProductDto> productDtos = productList.stream().toList().stream()
                .map(ProductDto -> new ProductDto(
                        ProductDto.getId(),
                        ProductDto.getProductName(),
                        ProductDto.getCategoryID().getCategoryName(),
                        ProductDto.getDescription(),
                        currencyInstance.format(ProductDto.getUnitPrice()),
                        ProductDto.getDiscontinue() ? "Yes" : "No",
                        ProductDto.getSellerID().getFullName()
                ))
                .collect(java.util.stream.Collectors.toList());
        return productDtos;
    }

    public ProductDetailsDto findByIdProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
        return ProductDetailsDto.set(product);
    }

}
