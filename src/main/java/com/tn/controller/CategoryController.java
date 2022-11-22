package com.tn.controller;

import com.tn.dto.CategoryDTO;
import com.tn.entity.Account;
import com.tn.entity.Category;
import com.tn.service.CategoryService;
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
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public String create(@RequestBody Category obj) {

        categoryService.save(obj);

        return "Add success";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Category> categories = categoryService.getAll();

        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(obj -> {
            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setId(obj.getId());
            categoryDTO.setCategoryName(obj.getCategoryName());
            categoryDTO.setDescription(obj.getDescription());

            categoryDTOS.add(categoryDTO);
        });

        model.addAttribute("listCategory", categoryDTOS);

        return "category-list";

    }


    @Transactional
    @GetMapping("deleteById/{pId}")
    public String delete(@PathVariable Integer pId) {
        categoryService.delete(pId);

        return "redirect:/category";
    }

    @Transactional
    @PostMapping("updateById/{pId}")
    public ResponseEntity<?> updateById(@PathVariable Integer pId,
                                        @RequestParam String pCategoryName,
                                        @RequestParam String pDescription) {
        categoryService.updateById(pId, pCategoryName, pDescription);
        return new ResponseEntity<>("update category successful", HttpStatus.OK);
    }

}
