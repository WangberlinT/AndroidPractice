package com.tiki.practiceset.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;

public class Browser extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_browser);
    WebView webView = findViewById(R.id.web_view);

    Intent intent = getIntent();
    String url = intent.getStringExtra("url");
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl(url);


  }

  public static void startActivity(Context context,String url)
  {
    Intent intent = new Intent(context, Browser.class);
    intent.putExtra("url", url);
    context.startActivity(intent);
  }
}
