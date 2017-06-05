package com.linh.zhpt.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.linh.zhpt.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/5/21.
 */

public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private RadioGroup radioGroup;
    //private ArrayList<BasePager>
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content,null);

        return view;
    }

    @Override
    public void initData() {

    }
}
