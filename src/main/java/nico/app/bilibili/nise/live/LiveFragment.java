package nico.app.bilibili.nise.live;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;

import java.util.ArrayList;
import java.util.List;

import nico.app.bilibili.nise.R;

/**
 * Created by Android on 2016/list_item_recommend/10.
 */

public class LiveFragment extends android.support.v4.app.Fragment
{
    private ConvenientBanner mConvenientBanner;
    private ListView lvLives;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.nico_fragment_live, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {

    }

    private void initialize()
    {
        lvLives.setAdapter(new InnerAdapter());

        mConvenientBanner.startTurning(2500);
    }

    private void loadLiveData()
    {

    }

    private class InnerAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return 0;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            Holder holder = null;
            if (convertView == null) {

                holder = new Holder();

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }


            return convertView;
        }

        private class Holder
        {
            ImageView mImageView_0;
            TextView mTextView_0;

            ImageView mImageView_1;
            TextView mTextView_1;

            ImageView mImageView_2;
            TextView mTextView_2;

            ImageView mImageView_3;
            TextView mTextView_3;
        }
    }
}
