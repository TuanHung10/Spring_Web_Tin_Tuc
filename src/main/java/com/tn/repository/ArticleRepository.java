package com.tn.repository;

import com.tn.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {


    @Modifying
    @Query("UPDATE Article set title=:pTitle, content=:pContent, image=:pImage WHERE id=:pId")
    void updateById(@Param("pId") int pId,
                    @Param("pTitle") String pTitle,
                    @Param("pContent") String pContent,
                    @Param("pImage") String pImage
    );

}
