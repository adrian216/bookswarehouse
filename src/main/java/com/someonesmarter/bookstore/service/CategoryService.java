package com.someonesmarter.bookstore.service;

import com.someonesmarter.bookstore.entity.Category;
import com.someonesmarter.bookstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
