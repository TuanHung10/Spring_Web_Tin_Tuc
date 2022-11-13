package com.tn.service;

import com.tn.entity.Article;
import com.tn.entity.Category;

import java.util.List;

public interface ArticleService {

    public List<Article> getAll();

    public List<Article> save();

    public void updateById(Integer pId, String pCategoryName, String pDescription);

    public void deleteById(Integer pId);
}
