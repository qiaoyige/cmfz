package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/6  17:33
 */
public interface GuruService {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 18:21
    *@Param [page, rows]
    *@Exception
    *@Return java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String,Object> queryAll(Integer page,Integer rows);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 19:46
    *@Param [guru]
    *@Exception
    *@Return boolean
    */
    public boolean addGuru(Guru guru);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 20:32
    *@Param [guru]
    *@Exception
    *@Return boolean
    */
    public boolean modifyGuru(Guru guru);

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 21:56
    *@Param [guru, page, rows]
    *@Exception
    *@Return java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String,Object> queryManyGuru(Guru guru,Integer page,Integer rows);

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/7 22:05
    *@Param [gurus]
    *@Exception
    *@Return int
    */
    public boolean addMany(List<Guru> gurus);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/8 12:54
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Guru>
    */
    public List<Guru> queryAlls();
}
