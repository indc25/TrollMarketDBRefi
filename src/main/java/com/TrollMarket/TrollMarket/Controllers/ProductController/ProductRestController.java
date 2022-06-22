package com.TrollMarket.TrollMarket.Controllers.ProductController;

import com.TrollMarket.TrollMarket.Dto.ProductDto.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Dto.ProductDto.ProductDto;
import com.TrollMarket.TrollMarket.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/product")
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("find-all")
    public List<ProductDto> findAllDto() {

        return productService.findAllProduct();
    }

    @GetMapping("/find-by-id/{id}")
    public ProductDetailsDto findByIdDto(@PathVariable Long id) {
        return productService.findByIdProduct(id);
    }
}
