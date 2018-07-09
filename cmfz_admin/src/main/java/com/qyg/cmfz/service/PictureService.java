package com.qyg.cmfz.service;

import com.qyg.cmfz.entity.Picture;

import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  20:10
 */
public interface PictureService {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/5 20:10
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Picture>
    */
    public Map<String, Object> queryAll(Integer page, Integer rows);


    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/5 22:11
    *@Param [picture]
    *@Exception
    *@Return boolean
    */
    public boolean addPicture(Picture picture);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 17:16
    *@Param [picture]
    *@Exception
    *@Return boolean
    */
    public boolean modifyPicture(Picture picture);
    
}
