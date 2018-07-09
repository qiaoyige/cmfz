package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.GuruDao;
import com.qyg.cmfz.entity.Guru;
import com.qyg.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/6  17:35
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao guruDao;
    @Override
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        List<Guru> gurus = guruDao.selectAllGuru((page - 1) * rows, rows);

        Integer count = guruDao.selectCount();

        Map<String,Object> map=new HashMap<String,Object>();

        map.put("total",count);
        map.put("rows",gurus);

        return map;
    }

    @Override
    public boolean addGuru(Guru guru) {
        if(guruDao.insertGuru(guru)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyGuru(Guru guru) {
        if(guruDao.updateGuru(guru)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Map<String, Object> queryManyGuru(Guru guru, Integer page, Integer rows) {
        List<Guru> gurus = guruDao.selectMany(guru,(page - 1) * rows, rows);

        Integer count = guruDao.selectManyCount(guru);

        Map<String,Object> map=new HashMap<String,Object>();

        map.put("total",count);
        map.put("rows",gurus);

        return map;
    }

    @Override
    public boolean addMany(List<Guru> gurus) {
        if(guruDao.insertMany(gurus)>0){
            return true;
        }else{
           return false;
        }
    }

    @Override
    public List<Guru> queryAlls() {
        return guruDao.selectAll();
    }
}
