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
  private int resourceId;

  public EntryAdapter(@NonNull Context context, int resource, @NonNull List<CatalogEntry> objects) {
    super(context, resource, objects);
    resourceId = resource;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view;
    ViewHolder viewHolder;
    CatalogEntry entry = getItem(position);
    if(convertView == null)
    {
      view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
      viewHolder = new ViewHolder();
      viewHolder.entryImg = view.findViewById(R.id.entry_img);
      viewHolder.entryText = view.findViewById(R.id.entry_name);
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
