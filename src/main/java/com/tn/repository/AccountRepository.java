package com.tn.repository;

import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


    @Modifying
    @Query("UPDATE Account set fullName=:pFullName, email=:pEmail WHERE id=:pId")
    void updateById(@Param("pId") int pId,
                    @Param("pFullName") String pFullName,
                    @Param("pEmail") String pEmail
    );

    }