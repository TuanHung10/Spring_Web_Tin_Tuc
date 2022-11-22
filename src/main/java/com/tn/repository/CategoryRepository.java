package com.tn.repository;

import com.tn.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    @Modifying
    @Query("UPDATE Category set categoryName=:pCategoryName, description=:pDescription WHERE id=:pId")
    void updateById(@Param("pId") int pId,
                    @Param("pCategoryName") String pCategoryName,
                    @Param("pDescription") String description
    );

}
