package nico.app.bilibili.nise.entity;

/**
 * Created by Android on 2016/12/1.
 */

public class Banner implements VideoItem
{
    // {
    //  "title": "萌战1130",
    private String mTitle;
    //  "value": "http://bangumi.bilibili.com/moe/2016/jp/mobile#!/",
    private String mValue;
    //  "image": "http://i0.hdslb.com/bfs/archive/6857f539e13287f8eae23b3fe0527bd21f8252cf.jpg",
    private String mImage;
    //  "type": 2,
    private int mType;
    //  "weight": 1,
    private int mWeight;
    //  "remark": "",
    private String mRemark;
    //  "hash": "968e591a5b07b4dd5c858b130fef169d"
    private String mHash;
    // }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getValue()
    {
        return mValue;
    }

    public void setValue(String value)
    {
        mValue = value;
    }

    public String getImage()
    {
        return mImage;
    }

    public void setImage(String image)
    {
        mImage = image;
    }

    public int getType()
    {
        return mType;
    }

    public void setType(int type)
    {
        mType = type;
    }

    public int getWeight()
    {
        return mWeight;
    }

    public void setWeight(int weight)
    {
        mWeight = weight;
    }

    public String getRemark()
    {
        return mRemark;
    }

    public void setRemark(String remark)
    {
        mRemark = remark;
    }

    public String getHash()
    {
        return mHash;
    }

    public void setHash(String hash)
    {
        mHash = hash;
    }
}
