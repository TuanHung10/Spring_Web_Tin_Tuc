package com.tn.service;

import com.tn.entity.Account;
import com.tn.entity.Article;

import java.util.List;

public interface AccountService {
    public List<Account> getAll();

    public List<Account> save();

    public void updateById(Integer pId, String pFullName, String pEmail);

    public void delete(Integer pId);
}
