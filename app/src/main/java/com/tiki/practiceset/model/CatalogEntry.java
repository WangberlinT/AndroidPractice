package com.tiki.practiceset.model;

public class CatalogEntry {
  private String name;//存储文本内容
  private int imageId;//存储图片
  private Class<?> nextActivity;

  public CatalogEntry(String name, int imageId,Class<?> nextActivity)
  {
    this.name = name;
    this.imageId = imageId;
    this.nextActivity = nextActivity;
  }

  public String getName()
  {
    return name;
  }

  public int getImageId()
  {
    return imageId;
  }

  public Class<?> getNextActivity(){ return nextActivity; }

}
