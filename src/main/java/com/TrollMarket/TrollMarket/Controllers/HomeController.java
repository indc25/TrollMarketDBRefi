package com.TrollMarket.TrollMarket.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

        @RequestMapping("/index")
        public String homePages(){
            return "home/home-index";
        }
}
