package com.tiki.practiceset.model;

public class CatalogEntry {
  private String name;
  private int imageId;
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
