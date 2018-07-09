package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.MenuDao;
import com.qyg.cmfz.entity.Menu;
import com.qyg.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  11:15
 */

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> queryAll() {
        return menuDao.selectAll();
    }
}
