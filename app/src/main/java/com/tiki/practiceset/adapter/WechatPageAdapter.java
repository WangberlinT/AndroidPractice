package com.tiki.practiceset.adapter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tiki.practiceset.model.ContactFragment;
import com.tiki.practiceset.model.WechatFragment;

public class WechatPageAdapter extends FragmentStatePagerAdapter {
  public static final int PAGENUM = 4;
  private Fragment[] fragments = new Fragment[PAGENUM];
  public WechatPageAdapter(@NonNull FragmentManager fm) {
    super(fm);
    fragments[0] = new WechatFragment();
    fragments[1] = new ContactFragment();
    fragments[2] = new ContactFragment();
    fragments[3] = new ContactFragment();
  }

  /*
    fragment 出现时
   */
  @NonNull
  @Override
  public Fragment getItem(int position) {
    Log.d("WechatAdapter", "getItem 调用");
    return fragments[position];
  }

  @Override
  public int getCount() {
    return PAGENUM;
  }
}
