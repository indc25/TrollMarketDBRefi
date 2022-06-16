package com.TrollMarket.TrollMarket.RestController;

import com.TrollMarket.TrollMarket.Dto.Shop.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find-by-id/{id}")
    public ProductDetailsDto findByIdDto(@PathVariable Long id) {
        return productService.findByIdProduct(id);
    }

}
