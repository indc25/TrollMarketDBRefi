package com.TrollMarket.TrollMarket.Controllers.CategoryController;

import com.TrollMarket.TrollMarket.Dto.CategoryDto;
import com.TrollMarket.TrollMarket.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/category")
public class CategoryRestController {
    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("find-all")
    public List<CategoryDto> findAllDto() {

        return categoryService.findAllCategory();
    }

}
