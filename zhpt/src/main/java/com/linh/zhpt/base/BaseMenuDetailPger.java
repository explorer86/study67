package com.linh.zhpt.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by ASUS on 2017/6/11.
 */

public abstract class BaseMenuDetailPger {
    public Activity mActivity;
    public View mRootView;

    public BaseMenuDetailPger(Activity activity){
        mActivity = activity;
        mRootView = initView();
    }

    public abstract View initView();
    public void initData(){

    }
}
