package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Permission;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  20:08
 */
public interface PermissionService {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/12 20:08
    *@Param [name]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Permission>
    */
    public List<Permission> queryAll(String name);
}
