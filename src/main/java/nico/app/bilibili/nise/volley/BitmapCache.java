package nico.app.bilibili.nise.volley;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.WeakHashMap;

import nico.app.bilibili.nise.utils.MD5;

/**
 * Created by Android on 2016/list_item_recommend/22.
 */

public class BitmapCache implements ImageLoader.ImageCache
{
    private WeakHashMap<String, Bitmap> mMap = new WeakHashMap<>();

    private String mCachePath;

    public BitmapCache(Context context)
    {
        mCachePath = context.getCacheDir().getPath() + "/image/";
        File file = new File(mCachePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Override
    public Bitmap getBitmap(String url)
    {
        Bitmap bitmap = mMap.get(url);
        if (bitmap != null) {
            return bitmap;
        }
        return loadBitmapFromFile(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap)
    {
        mMap.put(url, bitmap);
        saveBitmapToFile(url, bitmap);
    }

    private Bitmap loadBitmapFromFile(String url)
    {
        String path = mCachePath + MD5.getInstance().getMD5(url);
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }

    private void saveBitmapToFile(String url, Bitmap bitmap)
    {
        String path = mCachePath + MD5.getInstance().getMD5(url);
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
//
//    private LruCache<String, Bitmap> mCache;
//
//    public BitmapCache()
//    {
//        int maxSize = 10 * 1024 * 1024;
//        mCache = new LruCache<String, Bitmap>(maxSize)
//        {
//            @Override
//            protected int sizeOf(String key, Bitmap bitmap)
//            {
//                return bitmap.getRowBytes() * bitmap.getHeight();
//            }
//        };
//    }
//
//    @Override
//    public Bitmap getBitmap(String url)
//    {
//        return mCache.get(url);
//    }
//
//    @Override
//    public void putBitmap(String url, Bitmap bitmap)
//    {
//        mCache.put(url, bitmap);
//    }
}