package com.qyg.cmfz.entity;


public class Audio {

  private String audioId;
  private String audioName;
  private String audioSinger;
  private String audioCompose;
  private String audioArrangement;
  private String audioProducer;
  private String audioSize;
  private String audioAdd;
  private Integer audioCount;


  public String getAudioId() {
    return audioId;
  }

  public void setAudioId(String audioId) {
    this.audioId = audioId;
  }


  public String getAudioName() {
    return audioName;
  }

  public void setAudioName(String audioName) {
    this.audioName = audioName;
  }


  public String getAudioSinger() {
    return audioSinger;
  }

  public void setAudioSinger(String audioSinger) {
    this.audioSinger = audioSinger;
  }


  public String getAudioCompose() {
    return audioCompose;
  }

  public void setAudioCompose(String audioCompose) {
    this.audioCompose = audioCompose;
  }


  public String getAudioArrangement() {
    return audioArrangement;
  }

  public void setAudioArrangement(String audioArrangement) {
    this.audioArrangement = audioArrangement;
  }


  public String getAudioProducer() {
    return audioProducer;
  }

  public void setAudioProducer(String audioProducer) {
    this.audioProducer = audioProducer;
  }


  public String getAudioSize() {
    return audioSize;
  }

  public void setAudioSize(String audioSize) {
    this.audioSize = audioSize;
  }


  public String getAudioAdd() {
    return audioAdd;
  }

  public void setAudioAdd(String audioAdd) {
    this.audioAdd = audioAdd;
  }


  public long getAudioCount() {
    return audioCount;
  }

  public void setAudioCount(Integer audioCount) {
    this.audioCount = audioCount;
  }

  public Audio() {
  }

  public Audio(String audioId, String audioName, String audioSinger, String audioCompose, String audioArrangement, String audioProducer, String audioSize, String audioAdd, Integer audioCount) {
    this.audioId = audioId;
    this.audioName = audioName;
    this.audioSinger = audioSinger;
    this.audioCompose = audioCompose;
    this.audioArrangement = audioArrangement;
    this.audioProducer = audioProducer;
    this.audioSize = audioSize;
    this.audioAdd = audioAdd;
    this.audioCount = audioCount;
  }

  @Override
  public String toString() {
    return "Audio{" +
            "audioId='" + audioId + '\'' +
            ", audioName='" + audioName + '\'' +
            ", audioSinger='" + audioSinger + '\'' +
            ", audioCompose='" + audioCompose + '\'' +
            ", audioArrangement='" + audioArrangement + '\'' +
            ", audioProducer='" + audioProducer + '\'' +
            ", audioSize='" + audioSize + '\'' +
            ", audioAdd='" + audioAdd + '\'' +
            ", audioCount=" + audioCount +
            '}';
  }
}
