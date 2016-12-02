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
import nico.app.bilibili.nise.entity.Bangumi2;
import nico.app.bilibili.nise.entity.VideoItem;
import nico.app.bilibili.nise.volley.VolleyUtils;

/**
 * Created by Android on 2016/list_item_recommend/29.
 */

public class BangumiAdapter extends VideoItemAdapter
{
    private List<VideoItem> mVideoItems;

    private LayoutInflater mInflater;

    public BangumiAdapter(List<VideoItem> videoItems, LayoutInflater inflater)
    {
        super(videoItems, inflater);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_item_bangumi2, null);
            holder.ivCover = (ImageView) convertView.findViewById(R.id.cover);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            holder.btnDesc1 = (Button) convertView.findViewById(R.id.desc1);
            holder.btnStatus = (Button) convertView.findViewById(R.id.status);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Bangumi2 bangumi = (Bangumi2) mVideoItems.get(position);

        VolleyUtils.bindImage(holder.ivCover, bangumi.getCover());
        holder.tvTitle.setText(bangumi.getTitle());
        holder.btnDesc1.setText(bangumi.getDesc1());
        holder.btnStatus.setText(bangumi.getStatus() + "");

        return convertView;
    }

    private class Holder
    {
        ImageView ivCover;
        TextView tvTitle;
        Button btnDesc1;
        Button btnStatus;
    }
}
