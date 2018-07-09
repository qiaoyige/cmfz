package com.qyg.cmfz.entity;


import java.io.Serializable;

public class Manager implements Serializable {

  private String mgrId;
  private String mgrName;
  private String mgrPwd;
  private String salt;
  private String status;


  public String getMgrId() {
    return mgrId;
  }

  public void setMgrId(String mgrId) {
    this.mgrId = mgrId;
  }


  public String getMgrName() {
    return mgrName;
  }

  public void setMgrName(String mgrName) {
    this.mgrName = mgrName;
  }


  public String getMgrPwd() {
    return mgrPwd;
  }

  public void setMgrPwd(String mgrPwd) {
    this.mgrPwd = mgrPwd;
  }


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Manager() {
  }

  public Manager(String mgrId, String mgrName, String mgrPwd, String salt, String status) {
    this.mgrId = mgrId;
    this.mgrName = mgrName;
    this.mgrPwd = mgrPwd;
    this.salt = salt;
    this.status = status;
  }

  @Override
  public String toString() {
    return "Manager{" +
            "mgrId='" + mgrId + '\'' +
            ", mgrName='" + mgrName + '\'' +
            ", mgrPwd='" + mgrPwd + '\'' +
            ", salt='" + salt + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
