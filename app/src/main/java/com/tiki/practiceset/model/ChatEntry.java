package com.tiki.practiceset.model;

public class ChatEntry {
  private String name;
  private String chatContent = "";
  private int protrait;


  public ChatEntry(String name, int protrait)
  {
    this.name = name;
    this.protrait = protrait;
  }

  public String getName()
  {
    return name;
  }

  public String getChatContent()
  {
    return chatContent;
  }

  public int getProtrait()
  {
    return protrait;
  }
}
