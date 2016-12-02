package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/2.
 */

public class Live implements VideoItem
{
//    {
//        "title": "B站第一男技师58554",
    private String mTitle;
//        "style": "gm_live",
    private String mStyle;
//        "cover": "http://i0.hdslb.com/bfs/live/0e882c8869cfd538922d6290d23791862f000415.jpg",
    private String mCover;
//        "param": "58554",
    private String mParam;
//        "goto": "live",
    private String mGoto;
//        "width": 580,
    private int mWidth;
//        "height": 364,
    private int mHeight;
//        "up_face": "http://i2.hdslb.com/bfs/face/d6b9d6d9b81e0005d786cd72b9e6b469a5d2c571.jpg",
    private String mUpFace;
//        "up": "铁块同学",
    private String mUp;
//        "online": 13026,
    private int mOnline;
//        "area": "电子竞技",
    private String mArea;
//        "area_id": 4
    private int mAreaId;
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

    public String getUpFace()
    {
        return mUpFace;
    }

    public void setUpFace(String upFace)
    {
        mUpFace = upFace;
    }

    public String getUp()
    {
        return mUp;
    }

    public void setUp(String up)
    {
        mUp = up;
    }

    public int getOnline()
    {
        return mOnline;
    }

    public void setOnline(int online)
    {
        mOnline = online;
    }

    public String getArea()
    {
        return mArea;
    }

    public void setArea(String area)
    {
        mArea = area;
    }

    public int getAreaId()
    {
        return mAreaId;
    }

    public void setAreaId(int areaId)
    {
        mAreaId = areaId;
    }
}
