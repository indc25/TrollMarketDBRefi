package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProductService;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired private ProfileService profileService;

    @Autowired private ProductService productService;

    @RequestMapping("/add")
    public String addMerchandise(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "merchandise/merchandise-add";
    }

    @RequestMapping("/index")
    public String homePages(Model model) {
        model.addAttribute("shop", productService.findProduct());
        model.addAttribute("profile", profileService.getProfileUserLogin());
        model.addAttribute("shopList", productService.findAllProduct());
        return "merchandise/merchandise-index";
    }

    @GetMapping("/discontinue")
    public String discontinue(@RequestParam Long id) {
        productService.discontinue(id);
        return "redirect:/merchandise/index";
    }
}
