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
import com.tiki.practiceset.model.ChatEntry;

import java.util.List;

public class FriendListAdapter extends ArrayAdapter<ChatEntry> {
  int resource;//friend list layout
  public FriendListAdapter(@NonNull Context context, int resource ,List<ChatEntry> list) {
    super(context, resource, list);
    this.resource = resource;
  }

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
    FriendListAdapter.ViewHolder viewHolder;
    ChatEntry entry = getItem(position);
    if(convertView == null)
    {
      //parent 的布局参数如何作用于这个？
      view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
      viewHolder = new FriendListAdapter.ViewHolder();
      viewHolder.entryImg = view.findViewById(R.id.portrait);
      viewHolder.nameText = view.findViewById(R.id.name);
      view.setTag(viewHolder);
    }
    else
    {
      view = convertView;
      viewHolder = (FriendListAdapter.ViewHolder) view.getTag();//不明白
    }
    //这里不知道为什么viewHolder会null
    if(viewHolder.entryImg != null)
      viewHolder.entryImg.setImageResource(entry.getProtrait());
    if(viewHolder.nameText != null)
      viewHolder.nameText.setText(entry.getName());
    if(viewHolder.chatText != null)
      viewHolder.chatText.setText(entry.getChatContent());
    return view;
  }

  class ViewHolder
  {
    ImageView entryImg;
    TextView nameText;
    TextView chatText;
  }
}
