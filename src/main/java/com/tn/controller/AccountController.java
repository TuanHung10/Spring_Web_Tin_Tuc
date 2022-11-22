package com.tn.controller;

import com.tn.entity.Account;
import com.tn.entity.Category;
import com.tn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public String create(@RequestBody Category obj) {

        categoryService.save(obj);

        return "Add success";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Account> accounts = accountService.getAll();

        model.addAttribute("listAccount", accounts);

        return "account-list";
    }


    @Transactional
    @GetMapping("delete/{pId}")
    public String delete(@PathVariable Integer pId) {

        accountService.delete(pId);

        return "redirect:/account";
    }

    @Transactional
    @PostMapping("updateById/{pId}")
    public ResponseEntity<?>updateById(@PathVariable Integer pId,
                                       @RequestParam String pFullName,
                                       @RequestParam String pEmail) {
        accountService.updateById(pId, pFullName, pEmail);
        return new ResponseEntity<>("update account successful", HttpStatus.OK);
    }

}
