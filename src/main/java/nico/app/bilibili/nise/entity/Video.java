package nico.app.bilibili.nise.entity;

import java.util.List;

/**
 * Created by Android on 2016/12/2.
 */

public class Video
{
    private String mType;
    private List<VideoItem> mVideoItems;

    public Video(String type, List<VideoItem> videoItems)
    {
        mType = type;
        mVideoItems = videoItems;
    }

    public String getType()
    {
        return mType;
    }

    public void setType(String type)
    {
        mType = type;
    }

    public List<VideoItem> getVideoItems()
    {
        return mVideoItems;
    }

    public void setVideoItems(List<VideoItem> videoItems)
    {
        mVideoItems = videoItems;
    }
}
