package nico.app.bilibili.nise.volley;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import nico.app.bilibili.nise.R;

/**
 * Created by Android on 2016/list_item_recommend/22.
 */

public class VolleyUtils
{
    private static RequestQueue sRequestQueue = null;
    private static ImageLoader sImageLoader = null;

    public static void init(Context context)
    {
        if (sRequestQueue == null) {
            sRequestQueue = Volley.newRequestQueue(context);
        }

        if (sImageLoader == null) {
            sImageLoader = new ImageLoader(sRequestQueue, new BitmapCache(context));
        }
    }

    public static void bindImage(ImageView imageView, String imageUrl)
    {
        sImageLoader.get(imageUrl, ImageLoader.getImageListener(imageView, R.drawable.bili_anim_tv_chan_3, R.drawable.bili_anim_tv_chan_5));
    }

    public static RequestQueue getRequestQueue()
    {
        return sRequestQueue;
    }
}
