package com.TrollMarket.TrollMarket.RestController;

import com.TrollMarket.TrollMarket.Dto.Shop.ProductDetailsDto;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductFeedBack;
import com.TrollMarket.TrollMarket.Dto.Shop.ProductSearchDto;
import com.TrollMarket.TrollMarket.Rest.RestResponse;
import com.TrollMarket.TrollMarket.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search-by")
    public ResponseEntity<RestResponse<List<ProductDetailsDto>>> searchBy(@RequestBody ProductSearchDto productSearchDto) {
        return new ResponseEntity(
                new RestResponse<>(
                        productService.searchBy(productSearchDto),
                        "Sukses Mencari Produk",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/find-by")
    public ResponseEntity<RestResponse<ProductFeedBack>> findBy(@RequestBody ProductSearchDto productSearchDto) {
        return new ResponseEntity(
                new RestResponse<>(
                        productService.findBy(productSearchDto),
                        "Sukses Mencari Produk",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }

}
