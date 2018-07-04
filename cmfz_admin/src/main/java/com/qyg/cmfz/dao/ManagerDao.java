package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @Description   Manager的DAO,对数据库进行操作
 * @Author gege
 * @Time 2018/7/4  16:36
 */
public interface ManagerDao {


    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/4 17:14
    *@Param [name]
    *@Exception
    *@Return com.qyg.cmfz.entity.Manager
    */
    public Manager selectByName(@Param("name") String name);
}
