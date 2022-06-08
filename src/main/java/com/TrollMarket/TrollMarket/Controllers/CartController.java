package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "Cart/cart-index";
    }
}
