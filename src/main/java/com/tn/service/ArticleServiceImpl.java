package com.tn.service;

import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> save() {
        return null;
    }

    @Override
    public void updateById(Integer pId, String pTitle, String pContent, String pImage) {
        articleRepository.updateById(pId, pTitle, pContent, pImage);
    }

    @Override
    public void delete(Integer pId) {
        articleRepository.deleteById(pId);
    }
}
