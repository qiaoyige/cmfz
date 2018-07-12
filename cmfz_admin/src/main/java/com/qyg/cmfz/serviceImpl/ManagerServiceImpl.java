package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.ManagerDao;
import com.qyg.cmfz.entity.Manager;
import com.qyg.cmfz.service.ManagerService;
import com.qyg.cmfz.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description Manager的业务逻辑层的实现层
 * @Author gege
 * @Time 2018/7/4  16:36
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager loginManager(String name, String password) {
        Manager manager = managerDao.selectByName(name);

        if(manager!=null ){

            String pwd = MD5.encryption(password+manager.getSalt());
            System.out.println(pwd);
            if(manager.getMgrPwd().equals(pwd)){
                return manager;
            }
        }
        return null;
    }

    @Override
    public Manager queryUserByName(String name) {
        return managerDao.selectByName(name);
    }
}
