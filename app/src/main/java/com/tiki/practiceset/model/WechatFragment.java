package com.tiki.practiceset.model;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tiki.practiceset.R;
import com.tiki.practiceset.adapter.FriendListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//生成
public class WechatFragment extends Fragment {
  private static String TAG = "WechatFragment";

  public WechatFragment() {

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.friends_list, container, false);
    initFriendList(view);
    return view;
  }

  private void initFriendList(View view)
  {
    int friendNum = 20;
    List<ChatEntry> chats = initFriends(friendNum);
    Context activity = getActivity();//获取宿主activity
    if(activity == null)
    {
      Log.d(TAG, "getActivity null");
      return;
    }
    FriendListAdapter friendListAdapter = new FriendListAdapter(activity,R.layout.friend_entry,chats);
    ListView listView = (ListView)(view.findViewById(R.id.friend_list));
    if(listView == null)
      Log.d(TAG, "listview null");
    else
      listView.setAdapter(friendListAdapter);
    Log.d(TAG, "initFriendList");
  }

  private List<ChatEntry> initFriends(int friendNum)
  {
    List<ChatEntry> chats = new ArrayList<>();
    Random random = new Random();

    for(int i = 0;i <friendNum; i++ )
    {
      float coin = random.nextFloat();
      if(coin > 0.5f)
      {
        chats.add(new ChatEntry("阿猫", R.drawable.cat));

      }
      else
      {
        chats.add(new ChatEntry("阿狗", R.drawable.dog));
      }

    }

    return chats;
  }
}
