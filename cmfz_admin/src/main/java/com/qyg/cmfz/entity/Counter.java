package com.qyg.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Counter implements Serializable {
  private String id;
  private String counterName;
  private Integer count;
  private String cid;
  private Date time;
  private String userId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCounterName() {
    return counterName;
  }

  public void setCounterName(String counterName) {
    this.counterName = counterName;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Counter() {
  }

  public Counter(String id, String counterName, Integer count, String cid, Date time, String userId) {
    this.id = id;
    this.counterName = counterName;
    this.count = count;
    this.cid = cid;
    this.time = time;
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Counter{" +
            "id='" + id + '\'' +
            ", counterName='" + counterName + '\'' +
            ", count=" + count +
            ", cid='" + cid + '\'' +
            ", time=" + time +
            ", userId='" + userId + '\'' +
            '}';
  }
}
