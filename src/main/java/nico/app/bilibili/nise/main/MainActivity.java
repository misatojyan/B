package nico.app.bilibili.nise.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import nico.app.bilibili.nise.R;
import nico.app.bilibili.nise.attentions.AttentionsFragment;
import nico.app.bilibili.nise.bangumi.BangumiFragment;
import nico.app.bilibili.nise.category.CategoryFragment;
import nico.app.bilibili.nise.discovers.DiscoversFragment;
import nico.app.bilibili.nise.home.HomeFragment;
import nico.app.bilibili.nise.live.LiveFragment;

@ContentView(R.layout.nico_activity_main)
public class MainActivity extends AppCompatActivity
{
    @ViewInject(R.id.rl_title_bar)
    private RelativeLayout rlTitleBar;

    @ViewInject(R.id.rg_tabs)
    private RadioGroup rgTabs;

    @ViewInject(R.id.vp_container)
    private ViewPager vpContainer;

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.nico_activity_main);
        x.view().inject(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mFragments = new ArrayList<Fragment>();
        mFragments.add(new LiveFragment());
        mFragments.add(new HomeFragment());
        mFragments.add(new BangumiFragment());
        mFragments.add(new CategoryFragment());
        mFragments.add(new AttentionsFragment());
        mFragments.add(new DiscoversFragment());

        vpContainer.setAdapter(new InnerFragmentPagerAdapterr(getSupportFragmentManager()));
        vpContainer.addOnPageChangeListener(new InnerOnPageChangeListener());
        vpContainer.setCurrentItem(1);

        rgTabs.setOnCheckedChangeListener(new InnerOnCheckedChangeListener());
        rgTabs.check(R.id.rb_home);
    }

    private long mLastDownTime;
    private int mBackPressCount;

    @Override
    public void onBackPressed()
    {
        long downTime = System.currentTimeMillis();
        if (downTime - mLastDownTime <= 1000) {
            mBackPressCount += 1;
        } else {
            mBackPressCount = 1;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
        }

        if (mBackPressCount >= 2) {
            finish();
        }

        mLastDownTime = downTime;
    }

    private float mDownX;
    private float mDownY;
    private int mLastTopMargin;
    private boolean isTitleBarHiding;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rlTitleBar.getLayoutParams();
        final int H = rlTitleBar.getHeight();
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mDownX = ev.getX();
            mDownY = ev.getY();
            mLastTopMargin = layoutParams.topMargin;
            isTitleBarHiding = false;
            break;

        case MotionEvent.ACTION_MOVE:
            float dx = ev.getX() - mDownX;
            float dy = ev.getY() - mDownY;
            if (Math.abs(dy) > Math.abs(dx)) {
                isTitleBarHiding = true;
            }
            if (isTitleBarHiding) {
                layoutParams.topMargin = (int) (mLastTopMargin + dy / 3);
                if (layoutParams.topMargin < -H) {
                    layoutParams.topMargin = -H;
                }
                if (layoutParams.topMargin > 0) {
                    layoutParams.topMargin = 0;
                }
                rlTitleBar.setLayoutParams(layoutParams);
            }
            break;

        case MotionEvent.ACTION_UP:
            if (layoutParams.topMargin > -H / 2) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = -H;
            }
            rlTitleBar.setLayoutParams(layoutParams);
            break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private class InnerOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            int index = 0;
            switch (checkedId) {
            case R.id.rb_live:
                index = 0;
                break;
            case R.id.rb_home:
                index = 1;
                break;
            case R.id.rb_bangumi:
                index = 2;
                break;
            case R.id.rb_category:
                index = 3;
                break;
            case R.id.rb_attentions:
                index = 4;
                break;
            case R.id.rb_discover:
                index = 5;
                break;
            }
            vpContainer.setCurrentItem(index, true);
        }
    }

    private class InnerFragmentPagerAdapterr extends FragmentPagerAdapter
    {

        public InnerFragmentPagerAdapterr(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragments.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragments.size();
        }
    }

    private class InnerOnPageChangeListener implements ViewPager.OnPageChangeListener
    {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }

        @Override
        public void onPageSelected(int position)
        {
            final int[] ids = {
                    R.id.rb_live,
                    R.id.rb_home,
                    R.id.rb_bangumi,
                    R.id.rb_category,
                    R.id.rb_attentions,
                    R.id.rb_discover,
            };
            rgTabs.check(ids[position]);
        }

        @Override
        public void onPageScrollStateChanged(int state)
        {

        }
    }
}
