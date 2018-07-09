package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  11:14
 */
public interface MenuService {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/5 11:15
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Menu>
    */
    public List<Menu> queryAll();
}
