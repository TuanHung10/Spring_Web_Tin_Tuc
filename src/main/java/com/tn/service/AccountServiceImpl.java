package com.tn.service;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> save() {
        return null;
    }

    @Override
    public void updateById(Integer pId, String pFullName, String pEmail) {
        accountRepository.updateById(pId, pFullName, pEmail);
    }

    @Override
    public void delete(Integer pId) {
        accountRepository.deleteById(pId);
    }
}
