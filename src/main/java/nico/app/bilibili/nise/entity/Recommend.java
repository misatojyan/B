package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Recommend implements VideoItem
{
//    {
//        "title": "随便出去走走 @野食小哥",
    private String mTitle;
//        "style": "gm_av",
    private String mStyle;
//        "cover": "http://i0.hdslb.com/bfs/archive/c267c99a42591d3f79ada2292725dca3256fb265.jpg",
    private String mCover;
//        "param": "7322136",
    private String mParam;
//        "goto": "av",
    private String mGoto;
//        "width": 350,
    private int mWidth;
//        "height": 219,
    private int mHeight;
//        "play": "13.5万",
    private String mPlay;
//        "danmaku": "3938"
    private String mDanmaku;
//    }


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

    public String getPlay()
    {
        return mPlay;
    }

    public void setPlay(String play)
    {
        mPlay = play;
    }

    public String getDanmaku()
    {
        return mDanmaku;
    }

    public void setDanmaku(String danmaku)
    {
        mDanmaku = danmaku;
    }
}
