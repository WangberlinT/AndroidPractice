package com.tiki.practiceset.model;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.tiki.practiceset.R;

public class TitleLayout extends RelativeLayout {

  private Button backBtn;

  public TitleLayout(final Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.layout_title,this);
  }
}
