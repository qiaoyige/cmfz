package com.qyg.cmfz.dao;

import com.qyg.cmfz.entity.Guru;
import com.qyg.cmfz.entity.Manager;
import com.qyg.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description   Manager的DAO,对数据库进行操作
 * @Author gege
 * @Time 2018/7/6  17:25
 */
public interface GuruDao {

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/6 17:26
    *@Param [start, end]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Guru>
    */
    public List<Guru> selectAllGuru(@Param("start") Integer start,@Param("end") Integer end);

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 17:29
    *@Param []
    *@Exception
    *@Return java.lang.Integer
    */
    public Integer selectCount();
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 19:36
    *@Param [guru]
    *@Exception
    *@Return java.lang.Integer
    */
    public int insertGuru(Guru guru);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 20:29
    *@Param [guru]
    *@Exception
    *@Return int
    */
    public int updateGuru(Guru guru);
    
    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/6 21:43
    *@Param [guru]
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Guru>
    */
    public List<Guru> selectMany(@Param("guru") Guru guru,@Param("start") Integer start,@Param("end") Integer end);

    public Integer selectManyCount(@Param("guru") Guru guru);

    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/7 22:58
    *@Param [gurus]
    *@Exception
    *@Return int
    */
    public int insertMany(List<Guru> gurus);


    /**
    *@Description 
    *@Author gege
    *@Time  2018/7/8 12:54
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Guru>
    */
    public List<Guru> selectAll();
}
