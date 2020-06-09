package com.tiki.practiceset;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollectior {
  private volatile static ActivityCollectior instance;
  private List<Activity> activities;
  private ActivityCollectior(){
    activities = new ArrayList<Activity>();
  }

  public static ActivityCollectior getInstance() {
    if(instance == null) {
      synchronized (ActivityCollectior.class){
        if(instance == null){
          instance = new ActivityCollectior();
        }
      }
    }
    return instance;
  }

  public void addActivity(Activity activity){
    activities.add(activity);
  }

  public void removeActivity(Activity activity){
    activities.remove(activity);
  }

  public void finishAll(){
    for(Activity activity : activities){
      if(!activity.isFinishing()){
        activity.finish();
      }
    }
  }

}
