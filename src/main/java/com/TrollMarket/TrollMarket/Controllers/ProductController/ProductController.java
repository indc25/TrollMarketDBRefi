package com.TrollMarket.TrollMarket.Controllers.ProductController;

import com.TrollMarket.TrollMarket.Services.ProfileService;
import com.TrollMarket.TrollMarket.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String homePages(
            @RequestParam (defaultValue = "") String productName,
            @RequestParam (defaultValue = "") String categoryName,
            @RequestParam (defaultValue = "") String description,
            Model model) {
//        List<ProductDto> productDtoList = productService.getAllProduct(productName);
        model.addAttribute("shop", productService.findProduct());
        model.addAttribute("profile", profileService.getProfileUserLogin());
        model.addAttribute("shopList", productService.getAllProduct(productName, categoryName, description));
        return "shop/shop-index";
    }
}
