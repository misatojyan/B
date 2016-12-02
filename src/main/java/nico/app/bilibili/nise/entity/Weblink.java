package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Weblink implements VideoItem
{
//{
//    "title": "",
    private String mTitle;
//    "style": "gl_normal",
    private String mStyle;
//    "cover": "http://i0.hdslb.com/bfs/archive/d2749eba4d9a6a79e2f92e6aa36b4202c886aec3.jpg",
    private String mCover;
//    "param": "\t http://www.bilibili.com/blackboard/activity-2017lantern.html",
    private String mParam;
//    "goto": "weblink",
    private String mGoto;
//    "width": 714,
    private int mWidth;
//    "height": 211
    private int mHeight;
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
}
