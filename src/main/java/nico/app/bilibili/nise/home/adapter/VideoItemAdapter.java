package nico.app.bilibili.nise.home.adapter;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.List;

import nico.app.bilibili.nise.entity.VideoItem;

/**
 * Created by Android on 2016/12/2.
 */

public abstract class VideoItemAdapter extends BaseAdapter
{
    protected List<VideoItem> mVideoItems;

    protected LayoutInflater mInflater;

    protected VideoItemAdapter(List<VideoItem> videoItems, LayoutInflater inflater)
    {
        mVideoItems = videoItems;
        mInflater = inflater;
    }

    public  List<VideoItem> getVideoItems()
    {
        return mVideoItems;
    }

    public void setVideoItems(List<VideoItem> videoItems)
    {
        mVideoItems = videoItems;
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        if (mVideoItems == null) {
            return 0;
        } else {
            return mVideoItems.size();
        }
    }

    @Override
    public Object getItem(int position)
    {
        return mVideoItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }
}
