package com.certprep.certprep.category.controller;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    // Inject Service
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> allCategories() {
        return new ResponseEntity<>(
                categoryService.getAllCategories(),   // ← call via instance, NOT static
                HttpStatus.OK
        );
    }

}
