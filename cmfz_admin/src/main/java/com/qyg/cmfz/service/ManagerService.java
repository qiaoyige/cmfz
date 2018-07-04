package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Manager;

/**
 * @Description  Manager的业务逻辑层
 * @Author gege
 * @Time 2018/7/4  16:36
 */
public interface ManagerService {

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/4 17:14
    *@Param [name, password]
    *@Exception
    *@Return com.qyg.cmfz.entity.Manager
    */
    public Manager loginManager(String name,String password);
}
