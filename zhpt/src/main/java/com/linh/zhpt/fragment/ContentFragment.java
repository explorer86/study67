package com.linh.zhpt.fragment;

import android.support.annotation.IdRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.linh.zhpt.MainActivity;
import com.linh.zhpt.R;
import com.linh.zhpt.base.BasePager;
import com.linh.zhpt.base.impl.GovAffairsPager;
import com.linh.zhpt.base.impl.HomePager;
import com.linh.zhpt.base.impl.NewsCenterPager;
import com.linh.zhpt.base.impl.SettingPager;
import com.linh.zhpt.base.impl.SmartServicePager;
import com.linh.zhpt.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/5/21.
 */

public class ContentFragment extends BaseFragment {
    private NoScrollViewPager mViewPager;
    private RadioGroup radioGroup;
    private ArrayList<BasePager> mPagers;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content,null);
        mViewPager = (NoScrollViewPager)view.findViewById(R.id.vp_content);
        radioGroup = (RadioGroup)view.findViewById(R.id.rg_group);
        return view;
    }

    @Override
    public void initData() {
            mPagers = new ArrayList<BasePager>();
        // 添加五个标签页
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsCenterPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new GovAffairsPager(mActivity));
        mPagers.add(new SettingPager(mActivity));
        mViewPager.setAdapter(new ContentAdapter());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_news:
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_smart:
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(3,false);
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4,false);
                        break;
                }
            }
        });
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            BasePager pager = mPagers.get(position);
            pager.initData();

            if (position == 0 || position == mPagers.size() - 1) {
                // 首页和设置页要禁用侧边栏
                setSlidingMenuEnable(false);
            } else {
                // 其他页面开启侧边栏
                setSlidingMenuEnable(true);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
    mPagers.get(0).initData();
        setSlidingMenuEnable(false);


    }

    class ContentAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

    protected void setSlidingMenuEnable(boolean enable){
        MainActivity mainUI = (MainActivity)mActivity;
        SlidingMenu slidingMenu = mainUI.getSlidingMenu();
        if(enable){
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else{
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}
