package com.tiki.practiceset.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;
import com.tiki.practiceset.adapter.FriendListAdapter;
import com.tiki.practiceset.adapter.WechatPageAdapter;
import com.tiki.practiceset.model.BottomLayout;
import com.tiki.practiceset.model.ChatEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WechatActivity extends BaseActivity {
  private ViewPager pager;
  private WechatPageAdapter adapter;
  private BottomLayout mTabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wechat);

    setupViews();

  }

  private void setupViews()
  {
    //获取ViewPager
    pager = findViewById(R.id.pager);
    //创建adapter,getSupportFragmentManager
    adapter = new WechatPageAdapter(getSupportFragmentManager());
    pager.setAdapter(adapter);
    mTabLayout = findViewById(R.id.main_bottom_tablayout);
    mTabLayout.setViewPager(pager);
  }


}
