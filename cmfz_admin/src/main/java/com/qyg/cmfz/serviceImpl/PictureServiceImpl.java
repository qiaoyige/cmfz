package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.PictureDao;
import com.qyg.cmfz.entity.Picture;
import com.qyg.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  20:03
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureDao pictureDao;
    @Override
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        List<Picture> pictures = pictureDao.selectAll((page - 1) * rows , rows);

        Integer count = pictureDao.selectCount();

        Map<String, Object> map=new HashMap<String,Object>();

        map.put("total", count);
        map.put("rows", pictures);
        return map;
    }

    @Override
    public boolean addPicture(Picture picture) {
        if(pictureDao.insertPicture(picture)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyPicture(Picture picture) {
        if(pictureDao.updatePicture(picture)>0){
            return true;
        }else{
            return false;
        }
    }
}
