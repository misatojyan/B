package nico.app.bilibili.nise.url;

/**
 * Created by Android on 2016/12/1.
 */

public class URLS
{
    // MainActivity`推荐`选项卡轮播图片请求地址
    private static final String MAIN_HOME_BANNER = "http://app.bilibili.com/x/banner?plat=4&build=428003&channel=bilih5";

    // MainActivity`推荐`选项卡视频列表请求地址
    private static final String MAIN_HOME_VIDEOS = "http://app.bilibili.com/x/show/old?appkey=1d8b6e7d45233436&build=428003&channel=bilih5&mobi_app=android&platform=android&screen=hdpi&ts=1479119061000&sign=ab254203f090068982d194f0a1070183";

    // MainActivity`直播`选项卡轮播图片及视频列表请求地址
    private static final String MAIN_LIVE = "http://live.bilibili.com/AppNewIndex/common?_device=android&platform=android&scale=hdpi";

    // 更新请求地址
    public static  final String BILI_UPDATE = "http://app.bilibili.com/x/v2/version/update?build=428003&channel=bilih5&seed=110&sdkint=17&model=iPhone20";

    // 启动界面splash信息请求地址
    public static final String BILI_SPLASH = "http://app.bilibili.com/x/v2/splash?mobi_app=android&build=428003&channel=bilih5&width=480&height=800&ver=0";
}
