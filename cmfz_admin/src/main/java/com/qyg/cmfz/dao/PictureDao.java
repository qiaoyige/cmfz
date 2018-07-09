package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  19:48
 */
public interface PictureDao {
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/5 20:02
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Picture>
    */
    public List<Picture> selectAll(@Param("start") Integer start,@Param("end") Integer end);

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/5 20.30
    *@Param []
    *@Exception
    *@Return java.lang.Integer
    */
    public Integer selectCount();

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/5 21:00
    *@Param [picture]
    *@Exception
    *@Return int
    */
    public int insertPicture(Picture picture);

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 15:06
    *@Param [picture]
    *@Exception
    *@Return int
    */
    public int updatePicture(Picture picture);


}
