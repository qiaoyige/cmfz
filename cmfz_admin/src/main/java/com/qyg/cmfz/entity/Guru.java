package com.qyg.cmfz.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Guru implements Serializable {

  @Excel(name = "编号",orderNum="0")
  private String masterId;
  @Excel(name = "姓名",orderNum="1")
  private String masterName;
  @Excel(name = "照片",orderNum="2")
  private String masterPhoto;
  @Excel(name = "简介",orderNum="3")
  private String masterSummary;


  public String getMasterId() {
    return masterId;
  }

  public void setMasterId(String masterId) {
    this.masterId = masterId;
  }


  public String getMasterName() {
    return masterName;
  }

  public void setMasterName(String masterName) {
    this.masterName = masterName;
  }


  public String getMasterPhoto() {
    return masterPhoto;
  }

  public void setMasterPhoto(String masterPhoto) {
    this.masterPhoto = masterPhoto;
  }


  public String getMasterSummary() {
    return masterSummary;
  }

  public void setMasterSummary(String masterSummary) {
    this.masterSummary = masterSummary;
  }

  public Guru() {
  }

  public Guru(String masterId, String masterName, String masterPhoto, String masterSummary) {
    this.masterId = masterId;
    this.masterName = masterName;
    this.masterPhoto = masterPhoto;
    this.masterSummary = masterSummary;
  }

  @Override
  public String toString() {
    return "Guru{" +
            "masterId='" + masterId + '\'' +
            ", masterName='" + masterName + '\'' +
            ", masterPhoto='" + masterPhoto + '\'' +
            ", masterSummary='" + masterSummary + '\'' +
            '}';
  }
}
