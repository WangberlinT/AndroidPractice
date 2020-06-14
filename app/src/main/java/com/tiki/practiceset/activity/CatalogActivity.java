package com.tiki.practiceset.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tiki.practiceset.BaseActivity;
import com.tiki.practiceset.R;
import com.tiki.practiceset.adapter.EntryAdapter;
import com.tiki.practiceset.model.CatalogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习demo目录导航
 */
public class CatalogActivity extends BaseActivity {

  private List<CatalogEntry> entries = new ArrayList<>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_catalog);//做了什么？
    initEntries();
    EntryAdapter adapter = new EntryAdapter(this,R.layout.content_list,entries);
    ListView listView = (ListView)findViewById(R.id.catalog_list);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CatalogEntry entry = entries.get(position);
        Intent intent = new Intent(CatalogActivity.this, entry.getNextActivity());
        startActivity(intent);
      }
    });
  }

  private void initEntries()
  {
    entries.add(new CatalogEntry("模仿Wechat布局练习",R.mipmap.home_normal,WechatActivity.class));
    entries.add(new CatalogEntry("Fragment练习",R.mipmap.ic_launcher_round,FragmentPractice.class));
    entries.add(new CatalogEntry("login 存储和广播练习",R.mipmap.ic_launcher_round, LoginPractice.class));
  }
}
