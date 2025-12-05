package com.certprep.certprep.category.service;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();   // ← instance call, not static
    }
}
