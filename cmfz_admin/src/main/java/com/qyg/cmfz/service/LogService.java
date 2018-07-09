package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Log;

import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  19:27
 */
public interface LogService {

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/9 19:29
    *@Param [page, rows]
    *@Exception
    *@Return java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String,Object> queryAllLog(Integer page,Integer rows);

    /**
    *@Description  添加日志信息
    *@Author gege
    *@Time  2018/7/9 20:39
    *@Param [log]
    *@Exception
    *@Return boolean
    */
    public boolean appendLog(Log log);
}
