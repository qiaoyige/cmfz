package com.qyg.cmfz.controller;

import com.qyg.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  19:33
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/showAllLog")
    public @ResponseBody Map<String,Object> showAllLog(Integer page,Integer rows){

        return logService.queryAllLog(page, rows);
    }
}
