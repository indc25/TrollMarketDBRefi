package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.CategoryDto;
import com.TrollMarket.TrollMarket.Models.Category;
import com.TrollMarket.TrollMarket.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepositories;

    @Autowired
    public CategoryService(CategoryRepository categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }

    public List<CategoryDto> findAllCategory() {

        List<Category> categoryList = categoryRepositories.findAll();
        List<CategoryDto> result = categoryList.stream()
                .map(category -> new CategoryDto(
                        category.getId(),
                        category.getCategoryName(),
                        category.getDescription()))
                .collect(Collectors.toList());
        return result;
    }

}
