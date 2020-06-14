package com.tiki.practiceset;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityCollectior.getInstance().addActivity(this);
    ActionBar actionBar = getSupportActionBar();
    if(actionBar != null)
    {
      actionBar.hide();
    }
  }

  @Override
  protected void onDestroy(){
    super.onDestroy();
    ActivityCollectior.getInstance().removeActivity(this);
  }
}
