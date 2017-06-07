package com.linh.zhpt.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.linh.zhpt.MainActivity;
import com.linh.zhpt.R;

/**
 * Created by ASUS on 2017/6/7.
 */

public class BasePager {
    public Activity mActivity;

    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;

    public View mRootView;

    public BasePager(Activity activity){
        mActivity = activity;
        mRootView = initView();
    }

    private View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager,null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton)view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        return view;
    }

    protected void toggle() {
        MainActivity mainUI = (MainActivity)mActivity;
        SlidingMenu slidingMenu = mainUI.getSlidingMenu();
        slidingMenu.toggle();
    }

    //初始化数据
    public void initData(){

    }
}
