package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProfileService;
import jdk.jfr.Category;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/index")
    public String homePages(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "history/history-index";
    }
}
