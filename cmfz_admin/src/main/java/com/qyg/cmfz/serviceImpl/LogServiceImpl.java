package com.qyg.cmfz.serviceImpl;

import com.qyg.cmfz.dao.LogDao;
import com.qyg.cmfz.entity.Log;
import com.qyg.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  19:29
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    @Override
    public Map<String, Object> queryAllLog(Integer page, Integer rows) {
        List<Log> logs = logDao.selectAllLog((page - 1) * rows, rows);

        Integer count = logDao.selectCountLog();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }

    @Override
    public boolean appendLog(Log log) {
        if(logDao.insertLog(log)>0){
            return true;
        }else{
            return false;
        }
    }
}
