package com.tiki.practiceset.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;

public class LoginPractice extends BaseActivity {
  private static int failCount = 0;
  private final String ACCOUNT = "admin";
  private final String PASSWORD = "123456";

  private SharedPreferences pref;
  private SharedPreferences.Editor editor;
  private EditText accountEdit;
  private EditText passwordEdit;
  private CheckBox remenber;
  private Button login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    failCount = 0;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_practice);
    pref = PreferenceManager.getDefaultSharedPreferences(this);
    accountEdit = findViewById(R.id.account);
    passwordEdit = findViewById(R.id.password);
    remenber = findViewById(R.id.remember_pass);
    boolean isRemenber = pref.getBoolean("remenber",false);
    if(isRemenber)
    {
      String account = pref.getString("account", "");
      String password = pref.getString("password", "");
      accountEdit.setText(account);
      passwordEdit.setText(password);
      remenber.setChecked(true);
    }

    login = findViewById(R.id.login);
    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String account = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        if(account.equals(ACCOUNT) && password.equals(PASSWORD))
        {
          editor = pref.edit();
          if(remenber.isChecked())
          {
            editor.putBoolean("remenber",true);
            editor.putString("account",account);
            editor.putString("password",password);
          }
          else
          {
            editor.clear();
          }
          editor.apply();
          finish();
        }
        else
        {
          failCount++;
          Toast.makeText(LoginPractice.this, "用户名或密码错误" + failCount + "次", Toast.LENGTH_SHORT).show();
          if(failCount == 3)
          {
            //TODO: 强制退出
          }
        }
      }
    });
  }
}
