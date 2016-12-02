package nico.app.bilibili.nise.discovers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nico.app.bilibili.nise.R;

/**
 * Created by Android on 2016/list_item_recommend/10.
 */

public class DiscoversFragment extends android.support.v4.app.Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.nico_fragment_discovers, null);
        return view;
    }
}
