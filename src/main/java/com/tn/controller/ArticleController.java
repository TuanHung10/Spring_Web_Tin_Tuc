package com.tn.controller;

import com.tn.dto.ArticleDTO;
import com.tn.entity.Account;
import com.tn.entity.Article;
import com.tn.entity.Category;
import com.tn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public String create(@RequestBody Category obj) {

        articleService.save(obj);

        return "Add success";
    }


    @GetMapping //Cau duoi tra ve list DTO thi thay response entity = List ArticleDTO cx dc, cho nhin code de hieu hon
    public String getAll(Model model) {
        List<Article> articles = articleService.getAll();

        List<ArticleDTO> articleDTOS = new ArrayList<>();
        articles.forEach(obj -> {
            ArticleDTO articleDTO = new ArticleDTO();

            articleDTO.setId(obj.getId());
            articleDTO.setContent(obj.getContent());
            articleDTO.setCreatedDate(obj.getCreatedDate());
            articleDTO.setTitle(obj.getTitle());
            articleDTO.setUpdatedDate(obj.getUpdatedDate());
            articleDTO.setCategoryName(obj.getCategory().getCategoryName());

            articleDTOS.add(articleDTO);
        });

        model.addAttribute("listArticle",articleDTOS);

        return "article-list";
    }

    @Transactional
    @GetMapping("deleteById/{pId}")
    public String delete(@PathVariable Integer pId) {

        articleService.delete(pId);

        return "redirect:/article";
    }


    @Transactional
    @PostMapping("updateById/{pId}")
    public ResponseEntity<?>updateById(@PathVariable Integer pId,
                                       @RequestParam String pTitle,
                                       @RequestParam String pContent,
                                       @RequestParam String pImage) {
        articleService.updateById(pId, pTitle, pContent, pImage);
        return new ResponseEntity<>("update article successful", HttpStatus.OK);
    }
    //Cach lay ra tat ca article va category cua no (many to one)
//    @GetMapping
//    public ResponseEntity<?> getAll2() {
//        List<Article> articles = articleService.getAll();
//
//        List<ArticleDTO> articleDTOS = new ArrayList<>();
//        articles.forEach(obj -> {
//            ArticleDTO articleDTO = new ArticleDTO();
//            articleDTO.setId(obj.getId());
//
//            articleDTO.setCategoryName(obj.getCategory().getCategoryName());
//
//            articleDTOS.add((articleDTO));
//        });
//        return new ResponseEntity<>(articleDTOS, HttpStatus.OK);
//    }
}
