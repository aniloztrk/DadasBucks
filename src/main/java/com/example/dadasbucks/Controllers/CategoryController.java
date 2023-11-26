package com.example.dadasbucks.Controllers;

import com.example.dadasbucks.Models.Category;
import com.example.dadasbucks.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
       return categoryRepository.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.delete(category);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category newCategory) {
        Category category = categoryRepository.findById(newCategory.getId()).orElse(null);
        if(category == null) return null;

        category.setId(newCategory.getId());
        category.setName(newCategory.getName());
        return categoryRepository.save(category);
    }
}
