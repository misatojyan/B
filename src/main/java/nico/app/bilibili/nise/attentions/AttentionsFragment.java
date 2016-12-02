package nico.app.bilibili.nise.attentions;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nico.app.bilibili.nise.R;

/**
 * Created by Android on 2016/list_item_recommend/10.
 */

public class AttentionsFragment extends android.support.v4.app.Fragment implements View.OnClickListener
{
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.nico_fragment_attentions, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(getActivity());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        // builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("谁特么点了我的按钮");
        builder.setContentText("谁特么那么大的胆子点了我的按钮?");
        builder.setTicker("谁特么点了我的按钮");
        builder.setOngoing(true);
        builder.setProgress(100, 40, false);
        manager.cancel(0);
        manager.notify(0, builder.getNotification());
    }
}
