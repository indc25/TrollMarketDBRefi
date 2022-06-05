package com.TrollMarket.TrollMarket.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    @GetMapping("find-all")
    public String findAllDtos() {

        return "Category/categories-index";
    }
}
