package com.tiki.practiceset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tiki.practiceset.R;
import com.tiki.practiceset.model.CatalogEntry;

import java.util.List;

public class EntryAdapter extends ArrayAdapter<CatalogEntry> {
  private int resourceId;//CatalogEntry

  public EntryAdapter(@NonNull Context context, int resource, @NonNull List<CatalogEntry> objects) {
    super(context, resource, objects);
    resourceId = resource;
  }

  //getView 在每个子项被滚动到屏幕内的时候调用

  /**
   *
   * @param position 该子项在ArrayAdapter中的位置
   * @param convertView 缓存之前的布局，之前是什么意思？
   * @param parent
   * @return
   */
  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view;
    ViewHolder viewHolder;
    CatalogEntry entry = getItem(position);
    if(convertView == null)
    {
      //parent 的布局参数如何作用于这个？
      view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
      viewHolder = new ViewHolder();
      viewHolder.entryImg = view.findViewById(R.id.entry_img);
      viewHolder.entryText = view.findViewById(R.id.entry_name);
      view.setTag(viewHolder);
    }
    else
    {
      view = convertView;
      viewHolder = (ViewHolder) view.getTag();
    }
    viewHolder.entryImg.setImageResource(entry.getImageId());
    viewHolder.entryText.setText(entry.getName());
    return view;
  }

  class ViewHolder
  {
    ImageView entryImg;
    TextView entryText;
  }
}
