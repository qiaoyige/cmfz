package com.qyg.cmfz.entity;


import java.util.Date;

public class Album {

  private String id;
  private String albumName;
  private String albumAuthor;
  private String albumCv;
  private Integer albumCount;
  private Integer albumScore;
  private String albumSrc;
  private Date publishDate;
  private String content;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }


  public String getAlbumAuthor() {
    return albumAuthor;
  }

  public void setAlbumAuthor(String albumAuthor) {
    this.albumAuthor = albumAuthor;
  }


  public String getAlbumCv() {
    return albumCv;
  }

  public void setAlbumCv(String albumCv) {
    this.albumCv = albumCv;
  }


  public long getAlbumCount() {
    return albumCount;
  }

  public void setAlbumCount(Integer albumCount) {
    this.albumCount = albumCount;
  }


  public long getAlbumScore() {
    return albumScore;
  }

  public void setAlbumScore(Integer albumScore) {
    this.albumScore = albumScore;
  }


  public String getAlbumSrc() {
    return albumSrc;
  }

  public void setAlbumSrc(String albumSrc) {
    this.albumSrc = albumSrc;
  }


  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(java.sql.Timestamp publishDate) {
    this.publishDate = publishDate;
  }


  public String getContent() {

    return content;
  }

  public void setContent(String content) {

    this.content = content;
  }

  public Album() {
  }

  public Album(String id, String albumName, String albumAuthor, String albumCv, Integer albumCount, Integer albumScore, String albumSrc, Date publishDate, String content) {
    this.id = id;
    this.albumName = albumName;
    this.albumAuthor = albumAuthor;
    this.albumCv = albumCv;
    this.albumCount = albumCount;
    this.albumScore = albumScore;
    this.albumSrc = albumSrc;
    this.publishDate = publishDate;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Album{" +
            "id='" + id + '\'' +
            ", albumName='" + albumName + '\'' +
            ", albumAuthor='" + albumAuthor + '\'' +
            ", albumCv='" + albumCv + '\'' +
            ", albumCount=" + albumCount +
            ", albumScore=" + albumScore +
            ", albumSrc='" + albumSrc + '\'' +
            ", publishDate=" + publishDate +
            ", content='" + content + '\'' +
            '}';
  }
}
