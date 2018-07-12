package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.RoleDao;
import com.qyg.cmfz.entity.Role;
import com.qyg.cmfz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/12  19:46
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> queryAllByName(String name) {
        return roleDao.selectAllByName(name);
    }
}
