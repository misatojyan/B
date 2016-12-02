package nico.app.bilibili.nise.utils;

import android.graphics.Bitmap;

import nico.app.bilibili.nise.size.Size;

/**
 * Created by Android on 2016/12/1.
 */

public class BitmapUtils
{
    @Deprecated
    public static Bitmap scale(Bitmap bitmap, int newWidth, int newHeight)
    {
        return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);
    }

    public static Bitmap scaleToWidth(Bitmap bitmap, float newWidth)
    {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        if (bitmapWidth > newWidth) {
            // newWidth / newHeight = bitmapWidth / bitmapHeight
            float newHeight = newWidth * bitmapHeight / bitmapWidth;
            return Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, true);
        } else {
            return bitmap;
        }
    }

    public static Bitmap scaleToHeight(Bitmap bitmap, float newHeight)
    {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        if (bitmapHeight > newHeight) {
            // newWidth / newHeight = bitmapWidth / bitmapHeight
            float newWidth = newHeight * bitmapWidth / bitmapHeight;
            return Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, true);
        } else {
            return bitmap;
        }
    }
}
