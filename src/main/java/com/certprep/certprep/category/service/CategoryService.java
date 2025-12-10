package com.certprep.certprep.category.service;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.category.repository.CategoryRepository;
import com.certprep.certprep.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category updateCategory(long id, Category categoryDetails) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Category Could not found with id" + id)));
        categoryToUpdate.setName(categoryDetails.getName());
        categoryToUpdate.setStatus(categoryDetails.getStatus());
        return categoryRepository.save(categoryToUpdate);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();   // ← instance call, not static
    }

    public Category getCategoryById(long id) {
        Category singleCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Category Could not found with id" + id)));
        return singleCategory;
    }
}
