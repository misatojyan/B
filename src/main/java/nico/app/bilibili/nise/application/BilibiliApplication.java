package nico.app.bilibili.nise.application;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

import java.lang.reflect.Field;

import nico.app.bilibili.nise.size.Size;
import nico.app.bilibili.nise.volley.VolleyUtils;

/**
 * Created by Android on 2016/12/1.
 */

public class BilibiliApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        // System.out.println("before: width = " + Size.SCREEN_WIDTH + ", height = " + Size.SCREEN_HEIGHT);
        initScreenSize();
        // System.out.println("after: width = " + Size.SCREEN_WIDTH + ", height = " + Size.SCREEN_HEIGHT);

        VolleyUtils.init(this);
    }

    private void initScreenSize()
    {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Point outSize = new Point();
        windowManager.getDefaultDisplay().getSize(outSize);

        Class<Size> screenClass = Size.class;
        try {
            Field screenWidthField = screenClass.getField("SCREEN_WIDTH");
            setFinalStaticField(screenWidthField, outSize.x);
            Field screenHeightField = screenClass.getField("SCREEN_HEIGHT");
            setFinalStaticField(screenHeightField, outSize.y);
        } catch (NoSuchFieldException e) {
        }
    }

    private void setFinalStaticField(Field field, Object newValue)
    {
        try {
            field.setAccessible(true);
//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, newValue);
        } /*catch (NoSuchFieldException e) {

        }*/ catch (IllegalAccessException e) {

        }
    }
}
