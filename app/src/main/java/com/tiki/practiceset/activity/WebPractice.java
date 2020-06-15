package com.tiki.practiceset.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPractice extends BaseActivity {

  private EditText editText;
  private TextView responseText;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web_practice);
    editText = findViewById(R.id.browser_url);
    responseText = findViewById(R.id.response_text);
    Button go = findViewById(R.id.browser_go);
    go.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String url = editText.getText().toString();
        //set Intent and extra data:url
        Browser.startActivity(WebPractice.this,url);
      }
    });

    Button sendRequest = (Button)findViewById(R.id.send_request);
    sendRequest.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendRequestWithHttpURLConnection();
      }
    });
  }

  private void sendRequestWithHttpURLConnection()
  {
    new Thread(new Runnable() {
      @Override
      public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try{

          URL url = new URL("http://baidu.com");
          String url_text = editText.getText().toString();
          if(url_text != null && url_text.length() != 0)
          {
            url = new URL(url_text);
          }
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.setConnectTimeout(8000);
          connection.setReadTimeout(8000);
          InputStream in = connection.getInputStream();
          reader = new BufferedReader(new InputStreamReader(in));
          StringBuilder response = new StringBuilder();
          String line;
          while((line = reader.readLine()) != null)
          {
            response.append(line);
          }
          showResponse(response.toString());
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        finally{
          if(reader != null){
            try {
              reader.close();
            }
            catch (IOException e)
            {
              e.printStackTrace();
            }
          }
          if(connection != null)
          {
            connection.disconnect();
          }
        }
      }
    }).start();
  }

  private void showResponse(final String response)
  {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        responseText.setText(response);
      }
    });
  }
}
