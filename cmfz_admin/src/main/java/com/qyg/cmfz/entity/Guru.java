package com.qyg.cmfz.entity;


public class Guru {

  private String masterId;
  private String masterName;
  private String masterPhoto;
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
