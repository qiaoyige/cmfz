package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Role;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  19:45
 */
public interface RoleService {

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/12 19:50
    *@Param [name]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Role>
    */
    public List<Role> queryAllByName(String name); 
}
