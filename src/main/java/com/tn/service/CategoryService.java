package com.tn.service;

import com.tn.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAll();

    public List<Category> save();

    public void updateById(Integer pId, String pTitle, String pContent);

    public void deleteById(Integer pId);
}
