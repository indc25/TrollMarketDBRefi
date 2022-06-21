package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProductService;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private ProfileService profileService;
    private ProductService productService;

    @Autowired
    public ShopController(ProfileService profileService, ProductService productService) {
        this.profileService = profileService;
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePages(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        model.addAttribute("productList", productService.getAllProduct());
        return "shop/shop-index";
    }
}
