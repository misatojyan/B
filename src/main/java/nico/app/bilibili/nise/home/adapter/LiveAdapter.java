package nico.app.bilibili.nise.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import nico.app.bilibili.nise.R;
import nico.app.bilibili.nise.entity.Live;
import nico.app.bilibili.nise.entity.Recommend;
import nico.app.bilibili.nise.entity.VideoItem;
import nico.app.bilibili.nise.volley.VolleyUtils;

/**
 * Created by Android on 2016/list_item_recommend/29.
 */

public class LiveAdapter extends VideoItemAdapter
{
    private List<VideoItem> mVideoItems;

    private LayoutInflater mInflater;

    public LiveAdapter(List<VideoItem> videoItems, LayoutInflater inflater)
    {
        super(videoItems, inflater);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_item_live, null);
            holder.ivCover = (ImageView) convertView.findViewById(R.id.cover);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            holder.btnUp = (Button) convertView.findViewById(R.id.up);
            holder.btnOnline = (Button) convertView.findViewById(R.id.online);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Live live = (Live) mVideoItems.get(position);

        VolleyUtils.bindImage(holder.ivCover, live.getCover());
        holder.tvTitle.setText(live.getTitle());
        holder.btnUp.setText(live.getUp());
        holder.btnOnline.setText(live.getOnline() + "");

        return convertView;
    }

    private class Holder
    {
        ImageView ivCover;
        TextView tvTitle;
        Button btnUp;
        Button btnOnline;
    }
}
