package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Article;

import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/8  20:12
 */
public interface ArticleService {

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/8 20:15
    *@Param [article]
    *@Exception
    *@Return boolean
    */
    public boolean addArticle(Article article);

    /**
    *@Description  文章列表
    *@Author gege
    *@Time  2018/7/9 10:21
    *@Param [page, rows]
    *@Exception
    *@Return java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String,Object> queryAllArticle(Integer page,Integer rows);
}
