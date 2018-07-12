package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Permission;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  20:03
 */
public interface PermissionDao {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/12 20:04
    *@Param [name]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Permission>
    */
    public List<Permission> selectAllByName(String name);
}
