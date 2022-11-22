package com.tn.service;

import com.tn.entity.Category;
import com.tn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> save() {
        return null;
    }

    @Override
    public void updateById(Integer pId, String pCategoryName, String pDescription) {
        categoryRepository.updateById(pId, pCategoryName, pDescription);
    }

    @Override
    public void delete(Integer pId) {
        categoryRepository.deleteById(pId);
    }
}
