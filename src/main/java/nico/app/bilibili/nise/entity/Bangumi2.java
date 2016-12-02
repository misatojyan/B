package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Bangumi2 implements VideoItem
{
//{
//    "title": "伯纳德小姐说。",
    private String mTitle;
//    "style": "gs_bangumi",
    private String mStyle;
//    "cover": "http://i1.hdslb.com/bfs/archive/f372ae5e17a7e85c4a8ea55639d0b99c97989444.jpg",
    private String mCover;
//    "param": "5537",
    private String mParam;
//    "goto": "bangumi_list",
    private String mGoto;
//    "width": 320,
    private int mWidth;
//    "height": 422,
    private int mHeight;
//    "desc1": "更新到第9话",
    private String mDesc1;
//    "status": 2
    private int mStatus;
//}

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getStyle()
    {
        return mStyle;
    }

    public void setStyle(String style)
    {
        mStyle = style;
    }

    public String getCover()
    {
        return mCover;
    }

    public void setCover(String cover)
    {
        mCover = cover;
    }

    public String getParam()
    {
        return mParam;
    }

    public void setParam(String param)
    {
        mParam = param;
    }

    public String getGoto()
    {
        return mGoto;
    }

    public void setGoto(String aGoto)
    {
        mGoto = aGoto;
    }

    public int getWidth()
    {
        return mWidth;
    }

    public void setWidth(int width)
    {
        mWidth = width;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public void setHeight(int height)
    {
        mHeight = height;
    }

    public String getDesc1()
    {
        return mDesc1;
    }

    public void setDesc1(String desc1)
    {
        mDesc1 = desc1;
    }

    public int getStatus()
    {
        return mStatus;
    }

    public void setStatus(int status)
    {
        mStatus = status;
    }
}
