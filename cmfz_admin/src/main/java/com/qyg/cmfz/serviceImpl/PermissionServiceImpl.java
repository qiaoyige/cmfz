package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.PermissionDao;
import com.qyg.cmfz.entity.Permission;
import com.qyg.cmfz.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  20:09
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> queryAll(String name) {
        return permissionDao.selectAllByName(name);
    }
}
