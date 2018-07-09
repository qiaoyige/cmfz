package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.ArticleDao;
import com.qyg.cmfz.entity.Article;
import com.qyg.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> queryAllArticle(Integer page, Integer rows) {

        List<Article> articles = articleDao.selectAllArticle((page - 1) * rows, rows);

        Integer countArticle = articleDao.selectCountArticle();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",countArticle);
        map.put("rows",articles);
        return map;
    }
}
