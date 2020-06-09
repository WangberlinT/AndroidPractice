package com.tiki.practiceset.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button catalogBtn = findViewById(R.id.catalog_btn);
    catalogBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,CatalogActivity.class);
        startActivity(intent);
      }
    });
  }
}
