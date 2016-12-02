package nico.app.bilibili.nise.splash;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;

import nico.app.bilibili.nise.R;
import nico.app.bilibili.nise.main.MainActivity;
import nico.app.bilibili.nise.size.Size;
import nico.app.bilibili.nise.utils.BitmapUtils;

@ContentView(R.layout.nico_activity_splash)
public class SplashActivity extends AppCompatActivity
{
    @ViewInject(R.id.splash)
    private ImageView ivSplash;

    @ViewInject(R.id.copyright)
    private ImageView ivCopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.nico_activity_splash);
        x.view().inject(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        initSplashImage();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }

//    <string name="app_name">哔哩哔哩•伪</string>
//    <color name="colorPrimary">#3F51B5</color>
//    <color name="colorPrimaryDark">#303F9F</color>
//    <color name="colorAccent">#FF4081</color>

    private void initSplashImage()
    {
        AssetManager assetManager = getAssets();
        try {
            Bitmap bitmapSplash = BitmapFactory.decodeStream(assetManager.open("splash/ic_splash_default.png"));
            scaleImage(ivSplash, bitmapSplash, 0.75f);

            Bitmap bitmapCopyright = BitmapFactory.decodeStream(assetManager.open("splash/ic_splash_copy.png"));
            scaleImage(ivCopyright, bitmapCopyright, 0.4f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scaleImage(ImageView imageView, Bitmap bitmap, float scaleRate)
    {
        Bitmap newBitmap = BitmapUtils.scaleToWidth(bitmap, Size.SCREEN_WIDTH * scaleRate);
        imageView.setImageBitmap(newBitmap);
        if (newBitmap != bitmap) {
            bitmap.recycle();
        }
    }
}
