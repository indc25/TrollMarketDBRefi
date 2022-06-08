package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "Admin/admin-index";
    }
}
