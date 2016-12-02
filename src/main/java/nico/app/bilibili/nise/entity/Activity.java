package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Activity implements VideoItem
{
//{
//    "title": "拜年祭之元宵会，一起来闹元宵吧！",
    private String mTitle;
//    "style": "gl_act",
    private String mStyle;
//    "cover": "http://i0.hdslb.com/bfs/archive/0149792c18638219c654c2d911a5feca82f73ebd.jpg",
    private String mCover;
//    "param": "http://www.bilibili.com/blackboard/activity-2017lantern-m.html",
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
