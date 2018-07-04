package com.qyg.cmfz.entity;


public class Category {

  private String id;
  private String categoryName;
  private String userId;
  private String distinguish;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getDistinguish() {
    return distinguish;
  }

  public void setDistinguish(String distinguish) {
    this.distinguish = distinguish;
  }

  public Category() {
  }

  public Category(String id, String categoryName, String userId, String distinguish) {
    this.id = id;
    this.categoryName = categoryName;
    this.userId = userId;
    this.distinguish = distinguish;
  }

  @Override
  public String toString() {
    return "Category{" +
            "id='" + id + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", userId='" + userId + '\'' +
            ", distinguish='" + distinguish + '\'' +
            '}';
  }
}
