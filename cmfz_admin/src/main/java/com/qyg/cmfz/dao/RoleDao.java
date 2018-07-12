package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Role;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  19:40
 */
public interface RoleDao {
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/12 19:46
    *@Param [name]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Role>
    */
    public List<Role> selectAllByName(String name);
}
