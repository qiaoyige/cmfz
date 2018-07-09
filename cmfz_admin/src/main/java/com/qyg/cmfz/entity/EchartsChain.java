package com.qyg.cmfz.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  14:40
 */
public class EchartsChain implements Serializable {

    private String name;
    private String value;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public EchartsChain() {
    }

    public EchartsChain(String name, String value, String sex) {
        this.name = name;
        this.value = value;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "EchartsChain{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
