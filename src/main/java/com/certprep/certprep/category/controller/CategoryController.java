package com.certprep.certprep.category.controller;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category saveCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category){
        Category updated = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
