package nico.app.bilibili.nise.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbannerdemo.NetworkImageHolderView;

import java.util.ArrayList;
import java.util.List;

import nico.app.bilibili.nise.R;
import nico.app.bilibili.nise.entity.Banner;
import nico.app.bilibili.nise.entity.Video;
import nico.app.bilibili.nise.home.adapter.HomeAdapter;
import nico.app.bilibili.nise.size.Size;

//import com.bigkoo.convenientbannerdemo.NetworkImageHolderView;
//import com.jayway.jsonpath.JsonPath;
//import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
//import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Android on 2016/list_item_recommend/10.
 */

public class HomeFragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener
{
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ConvenientBanner mConvenientBanner;
    private ListView mListView;

    private boolean mBannerLoaded;
    private boolean mRecommendLoaded;

    private HomePresenter mHomePresenter = new HomePresenter();

    private HomeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mSwipeRefreshLayout = (SwipeRefreshLayout) inflater.inflate(R.layout.nico_fragment_home, null);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);

        mConvenientBanner = (ConvenientBanner) inflater.inflate(R.layout.nico_banner, null);
        int width = Size.SCREEN_WIDTH;
        // width / height = BANNER_IMG_WIDTH / BANNER_IMG_HEIGHT
        int height = width * Size.BANNER_IMG_HEIGHT / Size.BANNER_IMG_WIDTH;
        // will add to the listview
        ListView.LayoutParams layoutParams = new ListView.LayoutParams(width, height);
        mConvenientBanner.setLayoutParams(layoutParams);
        // 设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
        mConvenientBanner.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});
        // 设置指示器的方向
        mConvenientBanner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

        mListView = (ListView) mSwipeRefreshLayout.findViewById(R.id.lv_container);
        mListView.addHeaderView(mConvenientBanner);
        mAdapter = new HomeAdapter(null, inflater);
        mListView.setAdapter(mAdapter);

        onRefresh();

        return mSwipeRefreshLayout;
    }

    @Override
    public void onRefresh()
    {
        mBannerLoaded = mRecommendLoaded = false;
        mSwipeRefreshLayout.setRefreshing(true);
        mHomePresenter.loadData(this);
    }

    public void onRefreshUpdate()
    {
        if (mBannerLoaded && mRecommendLoaded) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    public void showBanner(List<Banner> banners)
    {
        mBannerLoaded = true;
        onRefreshUpdate();

        // 网络加载图片
        List<String> imagesUrls = new ArrayList<String>();
        for (Banner banner : banners) {
            imagesUrls.add(banner.getImage());
        }
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>()
        {
            @Override
            public NetworkImageHolderView createHolder()
            {
                return new NetworkImageHolderView();
            }
        }, imagesUrls);
        mConvenientBanner.startTurning(2500);
    }

    public void showRecommend(List<Video> videos)
    {
        mRecommendLoaded = true;
        onRefreshUpdate();

        mAdapter.setVideos(videos);
        mAdapter.notifyDataSetChanged();
    }

//    private String[] mImageUrls = {
//            "http://i0.hdslb.com/bfs/bangumi/1550c23b4fc1f621eb37afb6810ffc299f6c5d41.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/744049bfa33961ec3764710c601d4e6d5a031ef7.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/537298a0c2b629922b5e70246d6f0facbb7c917c.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/5f6907e38eb9ad64790a1f58b999d7322bee6178.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/f586b0f48954553f044b571f026fa1569526abd8.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/192d7dec7a31ec41bc11074df5aafd8e482935c0.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/64aa52caaeec047857b04169a551ef0567d1795b.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/7c486bcc68f1c63c30c5bbdacac7d2809731e502.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/434e6b4b8cb1027cd464014a44062b7aef972253.jpg_400x125.jpg",
//            "http://i1.hdslb.com/400_125/u_user/7779f64ae49061b6a890a5d0f6082836.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/d9a1f6bfdf6335dd2259728c3d17481e423bc011.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/0f2722767b9d4e0e000ad8173f23e96ca7b5bdb0.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/45a7d58e04ea3d51adaad2f016587c552724d023.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/9d4df527d473663935bec0bf00ac3af8e142ded7.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b6fd15e20e02a0d14063dc80fe5467773c05cf83.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/8344d061b7ec56776b761063748f0fcafefda454.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/cf61046c8c05a12c53b06c3fa5b3b7905574ef3b.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/8c587840103adb37183476a83bea43fe3ad33af3.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/6f3c64b9da5b964ef9f783e10181e2f9b8c57d30.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/9c660e6e6174bd9cfa636f3240a8610c9beeff5e.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/59619c4d5845a484684ed9f21323836c50d6d63e.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/1467fe6700b24f29091d637cbf072f75f2938471.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/f06c74a5075a75e220b841e259125d489e553bda.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4404b4590ecdfa8c3dea4d76bcbb448a87fcfa46.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/148cd35ae2897328e8560e18fd83d41cc15bc4ac.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/3463463d4dac18f0ac776fcb9c70a339ac160195.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/3b686ecfb02d0da8cd3faa60e0b549c7c50b5749.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/7ccab4d31867d898ddd9b210334f5fa9a7b3414d.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b352eef0cbf25a1df0f4c9a45eedd9cca96fc452.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/e80db39f246d30f4580565fe7becfc7fa2f15f5a.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/5be006ea7ef99ec731cf93aeedcf9620df3c5a46.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/7813e9f7c59ec62b8b3388b7e7b89796f7162e30.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4d3e4829085ff3a58418f9a4c3939dc5cd513d27.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/f3fefe29e7858e98a180ba5528e73c419989dfa5.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b9af8d4d1e95443c14efde51670e9b7fc6aad8b9.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/f2f7aa78f2950c442613b9f45558827fefa8d5be.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4abfd146b9510f1e56f43f1d471871eff4aab06b.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/630927df07befbf736be726e561f2bba68426a5d.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/9ea11298f4f44d3b651ee8d87c7d80e0b2d85353.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/ea2d8ce256a3eb0b76daaed9b90ea2aa15fff916.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b290853099b1b95a6cf0354d314341dfff9d1a8f.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/8c502b080b8e8b41d3f2e39b746a9cff10934dfc.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4f0e05353e90f20e8c2cc1b0fac449b9cb454b7b.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/199bce5a38a632d8f4cce98daeb29a2c3a47e2d5.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/0fc28b415e57257b4586bd5cfbfc5ab20c7cc338.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4b7b372742e2bd728d7f4a70ff3aefc3976b2380.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/87da292b658aa7d30158ff0568b6624aba539ad3.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/f22a76920d5f6b904f518793242dc681159025dd.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/d409c8bf1f1ffb8167683fc8a414bed6724bc537.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/66c87626d9345c8c4c3999e90fcfb21f59ad6d99.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b0fad1d8b9c15ba06504b470e4c2576fababa6f0.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4f5bd975011b00805dccc28c5fc8f5f5030631d6.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b701fa0db5ebf51f655f5073b7a4746db53ccd91.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/e22fcfaa7c9f5789b9a164a731041cfbddb7e9e7.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/9174103dc64554813ed0c85e129d92ca8f2e0f76.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/b5002a0431ab0ad1ad734e00f0c642ccce6d6850.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/83b8dc4bfa155b6f037cbe743fbe2f11522c9679.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/38a57ba5966c74a1c27859b25534dab6677e91d5.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/a09f8d159869efacd8c6f1e83012fd4f7ebcbcf6.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/4ca0cdcb5ae73c1e416f88255913620da7649786.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/6c1f48cf0feadbaddb1f17d89205d6c4127ac3e9.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/0e1f0e3fcab660e382c387f20173ebb4aedb96aa.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/6a4d4d450a4b96109629a8f233358f2f273e032d.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/a13ea79a4a42f90468d7803ec371e3f1e23e7df6.jpg_400x125.jpg",
//            "http://i0.hdslb.com/bfs/bangumi/34781334daf7e1e1f998dc1c40e52d4f434c2297.jpg_400x125.jpg",
//    };
}
