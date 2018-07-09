package com.qyg.cmfz.controller;

import com.qyg.cmfz.entity.Menu;
import com.qyg.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  11:17
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    public @ResponseBody  List<Menu>  showAll(){
        return menuService.queryAll();
    }

}
