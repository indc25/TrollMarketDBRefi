package com.TrollMarket.TrollMarket.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @RequestMapping("find-all")
    public String findAllDtos() {

        return "Profile/profile-index";
    }
}
