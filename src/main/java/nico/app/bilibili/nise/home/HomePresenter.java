package nico.app.bilibili.nise.home;


import java.util.List;

import nico.app.bilibili.nise.entity.Banner;
import nico.app.bilibili.nise.entity.Video;

/**
 * Created by Android on 2016/list_item_recommend/29.
 */

public class HomePresenter
{
    private HomeModle mHomeModle = new HomeModle();

    public void loadData(final HomeFragment homeFragment)
    {
        mHomeModle.requestBannerData("http://app.bilibili.com/x/banner?plat=4&build=428003&channel=bilih5",
                new HomeModle.ListCallback<Banner>()
                {
                    @Override
                    public void onListLoaded(List<Banner> data)
                    {
                        System.out.println("############################\n" + data);
                        homeFragment.showBanner(data);
                    }
                });

        mHomeModle.requestVideoListData("http://app.bilibili.com/x/show/old?appkey=1d8b6e7d45233436&build=428003&channel=bilih5&mobi_app=android&platform=android&screen=hdpi&ts=1479119061000&sign=ab254203f090068982d194f0a1070183",
                new HomeModle.ListCallback<Video>()
                {
                    @Override
                    public void onListLoaded(List<Video> data)
                    {
                        System.out.println("############################\n" + data);
                        homeFragment.showRecommend(data);
                    }
                });
    }
}
