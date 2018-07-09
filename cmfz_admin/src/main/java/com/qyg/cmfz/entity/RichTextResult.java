package com.qyg.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/8  18:59
 */
public class RichTextResult implements Serializable {

    private Integer Errno;
    private List<String> data;

    public Integer getErrno() {
        return Errno;
    }

    public void setErrno(Integer errno) {
        Errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
