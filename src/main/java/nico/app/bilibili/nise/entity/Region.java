package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Region implements VideoItem
{
//{
//    "title": "《论忠犬攻和女王受的养成》【黑化+误导】【维勇】勇利的以下克上（yuri on ice)",
    private String mTitle;
//    "style": "gm_av",
    private String mStyle;
//    "cover": "http://i0.hdslb.com/bfs/archive/abaae8f9b05fde4c2364e90fb77ff3d54f33c0fd.jpg_320x200.jpg",
    private String mCover;
//    "param": "7315115",
    private String mParam;
//    "goto": "av",
    private String mGoto;
//    "width": 350,
    private int mWidth;
//    "height": 219,
    private int mHeight;
//    "play": "5534",
    private String mPlay;
//    "danmaku": "43"
    private String mDanmaku;
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
