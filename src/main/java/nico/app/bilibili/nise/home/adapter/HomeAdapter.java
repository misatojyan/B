package nico.app.bilibili.nise.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.List;

import nico.app.bilibili.nise.R;
import nico.app.bilibili.nise.entity.Video;

/**
 * Created by Android on 2016/12/2.
 */

public class HomeAdapter extends BaseAdapter
{
    private List<Video> mVideos;
    private LayoutInflater mInflater;

    public HomeAdapter(List<Video> videos, LayoutInflater inflater)
    {
        this.mVideos = videos;
        mInflater = inflater;
    }

    public List<Video> getVideos()
    {
        return mVideos;
    }

    public void setVideos(List<Video> videos)
    {
        mVideos = videos;
    }

    @Override
    public int getCount()
    {
        if (mVideos == null) {
            return 0;
        } else {
            return mVideos.size();
        }
    }

    @Override
    public Object getItem(int position)
    {
        return mVideos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        String[] types = {
                "recommend",
                "live",
                "bangumi_2",
                "weblink",
                "region",
                "activity",
        };
        return types.length;
    }

    private static final int TYPE_RECOMMEND = 0;
    private static final int TYPE_LIVE = 1;
    private static final int TYPE_BANGUMI = 2;
    private static final int TYPE_WEBLINK = 3;
    private static final int TYPE_REGION = 4;
    private static final int TYPE_ACTIVITY = 5;

    @Override
    public int getItemViewType(int position)
    {
        switch (mVideos.get(position).getType()) {
        case "recommend":
            return TYPE_RECOMMEND;
        case "live":
            return TYPE_LIVE;
        case "bangumi_2":
            return TYPE_BANGUMI;
        case "weblink":
            return TYPE_WEBLINK;
        case "region":
            return TYPE_REGION;
        case "activity":
            return TYPE_ACTIVITY;
        default:
            return TYPE_REGION;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            int layout = 0;
            VideoItemAdapter adapter = null;
            switch (mVideos.get(position).getType()) {
            case "recommend":
                layout = R.layout.nico_video_group_recommend;
                adapter = new RecommendAdapter(null, mInflater);
                return getRecommendView(position, convertView, parent);
            case "live":
                layout = R.layout.nico_video_group_live;
                adapter = new LiveAdapter(null, mInflater);
                return getLiveView(position, convertView, parent);
            case "bangumi_2":
                adapter = new BangumiAdapter(null, mInflater);
                layout = R.layout.nico_video_group_bangumi;
                return getBangumi2View(position, convertView, parent);
            case "weblink":
                layout = R.layout.nico_video_group_weblink;
                return getWeblinkView(position, convertView, parent);
            case "region":
                layout = R.layout.nico_video_group_region;
                adapter = new RegionAdapter(null, mInflater);
                return getRegionView(position, convertView, parent);
            case "activity":
                layout = R.layout.nico_video_group_activity;
                return getActivityView(position, convertView, parent);
            default:
                layout = R.layout.nico_video_group_region;
                adapter = new RegionAdapter(null, mInflater);
                return getRegionView(position, convertView, parent);
            }
        }
        return convertView;
    }

    private View getRecommendView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_group_recommend, null);
            holder.gvContainer = (GridView) convertView.findViewById(R.id.container);
            holder.mType = "recommend";
            holder.mAdapter = new RecommendAdapter(null, mInflater);
            holder.gvContainer.setAdapter(holder.mAdapter);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mAdapter.setVideoItems(mVideos.get(position).getVideoItems());

        return convertView;
    }

    private View getLiveView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_group_live, null);
            holder.gvContainer = (GridView) convertView.findViewById(R.id.container);
            holder.mType = "live";
            holder.mAdapter = new LiveAdapter(null, mInflater);
            holder.gvContainer.setAdapter(holder.mAdapter);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mAdapter.setVideoItems(mVideos.get(position).getVideoItems());

        return convertView;
    }

    private View getBangumi2View(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_group_bangumi, null);
            holder.gvContainer = (GridView) convertView.findViewById(R.id.container);
            holder.mType = "bangumi_2";
            holder.mAdapter = new BangumiAdapter(null, mInflater);
            holder.gvContainer.setAdapter(holder.mAdapter);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mAdapter.setVideoItems(mVideos.get(position).getVideoItems());

        return convertView;
    }

    private View getWeblinkView(int position, View convertView, ViewGroup parent)
    {
        return convertView;
    }

    private View getActivityView(int position, View convertView, ViewGroup parent)
    {
        return convertView;
    }

    private View getRegionView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.nico_video_group_bangumi, null);
            holder.gvContainer = (GridView) convertView.findViewById(R.id.container);
            holder.mType = "region";
            holder.mAdapter = new RegionAdapter(null, mInflater);
            holder.gvContainer.setAdapter(holder.mAdapter);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mAdapter.setVideoItems(mVideos.get(position).getVideoItems());

        return convertView;
    }

    private class Holder
    {
        String mType;
        GridView gvContainer;
        VideoItemAdapter mAdapter;
    }
}
