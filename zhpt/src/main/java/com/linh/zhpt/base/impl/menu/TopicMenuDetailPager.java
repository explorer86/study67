package com.linh.zhpt.base.impl.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.linh.zhpt.base.BaseMenuDetailPger;

/**
 * Created by ASUS on 2017/6/11.
 */

public class TopicMenuDetailPager extends BaseMenuDetailPger {
    public TopicMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        TextView view = new TextView(mActivity);
        view.setText("菜单详情页-专题");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        return view;
    }
}
