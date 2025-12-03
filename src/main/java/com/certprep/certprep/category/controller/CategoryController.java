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
@RequestMapping("/api/catagory")
public class CategoryController {
    // Inject Service
    // private final Service service;
    private final CategoryService categoryServcie;

    public CategoryController(CategoryService categoryServcie) {
        this.categoryServcie = categoryServcie;
    }

    // get catagory by status
    @GetMapping
    public ResponseEntity<List <Category>> allCategories(){
        return new ResponseEntity<>(CategoryService.getAllCategories(), HttpStatus.OK);
    }

}
