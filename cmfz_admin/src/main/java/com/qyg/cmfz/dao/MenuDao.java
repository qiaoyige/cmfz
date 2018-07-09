package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  10:29
 */
public interface MenuDao {

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/5 11:14
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Menu>
    */
    public List<Menu> selectAll();
}
