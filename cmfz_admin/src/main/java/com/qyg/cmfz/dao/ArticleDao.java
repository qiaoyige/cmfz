package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/8  20:06
 */
public interface ArticleDao {

    /**
    *@Description  创建文章
    *@Author gege
    *@Time  2018/7/8 20:07
    *@Param [article]
    *@Exception
    *@Return int
    */
    public int insertArticle(Article article);


    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/9 10:10
    *@Param [start, end]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Article>
    */
    public List<Article> selectAllArticle(@Param("start") Integer start, @Param("end")Integer end);
    
    /**
    *@Description 分页查询
    *@Author gege
    *@Time  2018/7/9 10:24
    *@Param []
    *@Exception
    *@Return java.lang.Integer
    */
    public Integer selectCountArticle();
}
