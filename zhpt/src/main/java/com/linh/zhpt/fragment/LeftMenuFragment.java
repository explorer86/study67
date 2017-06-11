package com.linh.zhpt.fragment;

import android.view.View;
import android.widget.ListView;

import com.linh.zhpt.R;

/**
 * Created by ASUS on 2017/6/11.
 */

public class LeftMenuFragment extends BaseFragment {
    private ListView lvList;
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu,null);
        lvList = (ListView) view.findViewById(R.id.lv_list);
        return view;
    }

    @Override
    public void initData() {

    }
}
