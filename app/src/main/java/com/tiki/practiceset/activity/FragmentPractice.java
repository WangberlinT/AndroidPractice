package com.tiki.practiceset.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;
import com.tiki.practiceset.model.AnotherRightFragment;

public class FragmentPractice extends BaseActivity implements View.OnClickListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment_practice);
    Button button = findViewById(R.id.button);
    button.setOnClickListener(this);

  }


  @Override
  public void onClick(View v) {
    switch (v.getId())
    {
      case R.id.button:
        replaceFragment(new AnotherRightFragment());
        break;
      default:
        break;
    }
  }

  private void replaceFragment(Fragment fragment)
  {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction transaction = fm.beginTransaction();
    transaction.replace(R.id.right_fragment,fragment);
    transaction.commit();
  }
}
