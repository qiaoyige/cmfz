package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.ArticleDao;
import com.qyg.cmfz.entity.Article;
import com.qyg.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/8  20:13
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    @Override
    public boolean addArticle(Article article) {
        if(articleDao.insertArticle(article)>0){
            return true;
        }else{
            return false;
        }
    }
}
