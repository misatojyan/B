package nico.app.bilibili.nise.home;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nico.app.bilibili.nise.entity.Activity;
import nico.app.bilibili.nise.entity.Bangumi2;
import nico.app.bilibili.nise.entity.Banner;
import nico.app.bilibili.nise.entity.Live;
import nico.app.bilibili.nise.entity.Recommend;
import nico.app.bilibili.nise.entity.Region;
import nico.app.bilibili.nise.entity.Video;
import nico.app.bilibili.nise.entity.VideoItem;
import nico.app.bilibili.nise.entity.Weblink;
import nico.app.bilibili.nise.volley.VolleyUtils;


/**
 * Created by Android on 2016/list_item_recommend/29.
 */

public class HomeModle
{
    public void requestBannerData(String url, final ListCallback<Banner> callback)
    {
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Log.d("TAG", response);
                        callback.onListLoaded(parseBannerData(response));
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
        VolleyUtils.getRequestQueue().add(stringRequest);
    }

    public void requestVideoListData(String url, final ListCallback<Video> callback)
    {
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Log.d("TAG", response);
                        callback.onListLoaded(parseVideoListData(response));
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
        VolleyUtils.getRequestQueue().add(stringRequest);
    }

    private List<Banner> parseBannerData(String bannerData)
    {
        List<Banner> banners = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONObject(bannerData).getJSONArray("data");
            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Banner banner = new Banner();
                // {
                //  "title": "萌战1130",
                banner.setTitle(jsonObject.getString("title"));
                //  "value": "http://bangumi.bilibili.com/moe/2016/jp/mobile#!/",
                banner.setValue(jsonObject.getString("value"));
                //  "image": "http://i0.hdslb.com/bfs/archive/6857f539e13287f8eae23b3fe0527bd21f8252cf.jpg",
                banner.setImage(jsonObject.getString("image"));
                //  "type": 2,
                banner.setType(jsonObject.getInt("type"));
                //  "weight": 1,
                banner.setWeight(jsonObject.getInt("weight"));
                //  "remark": "",
                banner.setRemark(jsonObject.getString("remark"));
                //  "hash": "968e591a5b07b4dd5c858b130fef169d"
                banner.setHash(jsonObject.getString("hash"));
                // }
                banners.add(banner);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return banners;
    }

    private List<Video> parseVideoListData(String videoData)
    {
        List<Video> videos = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONObject(videoData).getJSONArray("result");
            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String type = jsonObject.getString("type");
                JSONArray body = jsonObject.getJSONArray("body");
                switch (type)
                {
                case "recommend":
                    videos.add(new Video(type, parseRecommendData(body)));
                    break;
                case "live":
                    videos.add(new Video(type, parseLiveData(body)));
                    break;
                case "bangumi_2":
                    videos.add(new Video(type, parseBangumi2Data(body)));
                    break;
                case "weblink":
                    videos.add(new Video(type, parseWeblinkData(body)));
                    break;
                case "region":
                    videos.add(new Video(type, parseRegionData(body)));
                    break;
                case "activity":
                    videos.add(new Video(type, parseActivityData(body)));
                    break;
                default:
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return videos;
    }

    private List<VideoItem> parseActivityData(JSONArray body)
    {
        List<VideoItem> activities = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Activity activity = new Activity();
                //{
                //    "title": "拜年祭之元宵会，一起来闹元宵吧！",
                activity.setTitle(jsonObject.getString("title"));
                //    "style": "gl_act",
                activity.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i0.hdslb.com/bfs/archive/0149792c18638219c654c2d911a5feca82f73ebd.jpg",
                activity.setCover(jsonObject.getString("cover"));
                //    "param": "http://www.bilibili.com/blackboard/activity-2017lantern-m.html",
                activity.setParam(jsonObject.getString("param"));
                //    "goto": "weblink",
                activity.setGoto(jsonObject.getString("goto"));
                //    "width": 714,
                activity.setWidth(jsonObject.getInt("width"));
                //    "height": 211
                activity.setHeight(jsonObject.getInt("height"));
                //}
                activities.add(activity);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return activities;
    }

    private List<VideoItem> parseRegionData(JSONArray body)
    {
        List<VideoItem> regions = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Region region = new Region();
                //{
                //    "title": "《论忠犬攻和女王受的养成》【黑化+误导】【维勇】勇利的以下克上（yuri on ice)",
                region.setTitle(jsonObject.getString("title"));
                //    "style": "gm_av",
                region.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i0.hdslb.com/bfs/archive/abaae8f9b05fde4c2364e90fb77ff3d54f33c0fd.jpg_320x200.jpg",
                region.setCover(jsonObject.getString("cover"));
                //    "param": "7315115",
                region.setParam(jsonObject.getString("param"));
                //    "goto": "av",
                region.setGoto(jsonObject.getString("goto"));
                //    "width": 350,
                region.setWidth(jsonObject.getInt("width"));
                //    "height": 219,
                region.setHeight(jsonObject.getInt("height"));
                //    "play": "5534",
                region.setPlay(jsonObject.getString("play"));
                //    "danmaku": "43"
                region.setDanmaku(jsonObject.getString("danmaku"));
                //}
                regions.add(region);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return regions;
    }

    private List<VideoItem> parseWeblinkData(JSONArray body)
    {
        List<VideoItem> weblinks = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Weblink weblink = new Weblink();
                //{
                //    "title": "",
                weblink.setTitle(jsonObject.getString("title"));
                //    "style": "gl_normal",
                weblink.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i0.hdslb.com/bfs/archive/d2749eba4d9a6a79e2f92e6aa36b4202c886aec3.jpg",
                weblink.setCover(jsonObject.getString("cover"));
                //    "param": "\t http://www.bilibili.com/blackboard/activity-2017lantern.html",
                weblink.setParam(jsonObject.getString("param"));
                //    "goto": "weblink",
                weblink.setGoto(jsonObject.getString("goto"));
                //    "width": 714,
                weblink.setWidth(jsonObject.getInt("width"));
                //    "height": 211
                weblink.setHeight(jsonObject.getInt("height"));
                //}
                weblinks.add(weblink);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return weblinks;
    }

    private List<VideoItem> parseBangumi2Data(JSONArray body)
    {
        List<VideoItem> bangumis = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Bangumi2 bangumi = new Bangumi2();
                //{
                //    "title": "伯纳德小姐说。",
                bangumi.setTitle(jsonObject.getString("title"));
                //    "style": "gs_bangumi",
                bangumi.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i1.hdslb.com/bfs/archive/f372ae5e17a7e85c4a8ea55639d0b99c97989444.jpg",
                bangumi.setCover(jsonObject.getString("cover"));
                //    "param": "5537",
                bangumi.setParam(jsonObject.getString("param"));
                //    "goto": "bangumi_list",
                bangumi.setGoto(jsonObject.getString("goto"));
                //    "width": 320,
                bangumi.setWidth(jsonObject.getInt("width"));
                //    "height": 422,
                bangumi.setHeight(jsonObject.getInt("height"));
                //    "desc1": "更新到第9话",
                bangumi.setDesc1(jsonObject.getString("desc1"));
                //    "status": 2
                bangumi.setStatus(jsonObject.getInt("status"));
                //}
                bangumis.add(bangumi);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bangumis;
    }

    private List<VideoItem> parseLiveData(JSONArray body)
    {
        List<VideoItem> lives = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Live live = new Live();
                //{
                //    "title": "B站第一男技师58554",
                live.setTitle(jsonObject.getString("title"));
                //    "style": "gm_live",
                live.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i0.hdslb.com/bfs/live/0e882c8869cfd538922d6290d23791862f000415.jpg",
                live.setCover(jsonObject.getString("cover"));
                //    "param": "58554",
                live.setParam(jsonObject.getString("param"));
                //    "goto": "live",
                live.setGoto(jsonObject.getString("goto"));
                //    "width": 580,
                live.setWidth(jsonObject.getInt("width"));
                //    "height": 364,
                live.setHeight(jsonObject.getInt("height"));
                //    "up_face": "http://i2.hdslb.com/bfs/face/d6b9d6d9b81e0005d786cd72b9e6b469a5d2c571.jpg",
                live.setUpFace(jsonObject.getString("up_face"));
                //    "up": "铁块同学",
                live.setUp(jsonObject.getString("up"));
                //    "online": 13026,
                live.setOnline(jsonObject.getInt("online"));
                //    "area": "电子竞技",
                live.setArea(jsonObject.getString("area"));
                //    "area_id": 4
                live.setAreaId(jsonObject.getInt("area_id"));
                //}
                lives.add(live);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return lives;
    }

    private List<VideoItem> parseRecommendData(JSONArray body)
    {
        List<VideoItem> recommends = new ArrayList<>();
        int count = body.length();
        for (int i = 0; i < count; i++) {
            try {
                JSONObject jsonObject = body.getJSONObject(i);
                Recommend recommend = new Recommend();
                //{
                //    "title": "随便出去走走 @野食小哥",
                recommend.setTitle(jsonObject.getString("title"));
                //    "style": "gm_av",
                recommend.setStyle(jsonObject.getString("style"));
                //    "cover": "http://i0.hdslb.com/bfs/archive/c267c99a42591d3f79ada2292725dca3256fb265.jpg",
                recommend.setCover(jsonObject.getString("cover"));
                //    "param": "7322136",
                recommend.setParam(jsonObject.getString("param"));
                //    "goto": "av",
                recommend.setGoto(jsonObject.getString("goto"));
                //    "width": 350,
                recommend.setWidth(jsonObject.getInt("width"));
                //    "height": 219,
                recommend.setHeight(jsonObject.getInt("height"));
                //    "play": "13.5万",
                recommend.setPlay(jsonObject.getString("play"));
                //    "danmaku": "3938"
                recommend.setDanmaku(jsonObject.getString("danmaku"));
                //}
                recommends.add(recommend);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return recommends;
    }

    public interface ListCallback<T>
    {
        void onListLoaded(List<T> data);
    }
}
