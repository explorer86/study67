package com.linh.zhpt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.linh.zhpt.utils.PreUtils;

import java.util.ArrayList;



/**
 * Created by ASUS on 2017/5/14.
 */

public class GuideActivity extends Activity {
    private final String TAG="xmlh";
    private ViewPager mViewPager;
    private LinearLayout llContainer;
    private ArrayList<ImageView> mImageViewList;
    private Button btnStart;
    private ImageView ivRedPoint;
    private int[] mImageIds = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    private int mPointDistance;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        btnStart = (Button) findViewById(R.id.btn_start);
        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        ivRedPoint = (ImageView) findViewById(R.id.iv_point_red);

        initData();
        mViewPager.setAdapter(new GuideApater());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //   Log.d(TAG,"position="+position+" positionOffset="+positionOffset
                //      +" positionOffsetPixels="+positionOffsetPixels);
                int leftMargin = (int) (mPointDistance * positionOffset) + mPointDistance*position;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivRedPoint.getLayoutParams();
                params.leftMargin = leftMargin;
                ivRedPoint.setLayoutParams(params);
            }
            @Override
            public void onPageSelected(int position) {
                if (position == mImageViewList.size()-1){
                    btnStart.setVisibility(View.VISIBLE);
                }else{
                    //新手导航最后一页，显示“开始体验”按钮
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mPointDistance =  llContainer.getChildAt(1).getLeft()
                        - llContainer.getChildAt(0).getLeft();
                Log.d(TAG,"distance="+mPointDistance);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreUtils.setBoolean(getApplicationContext(),"is_first_enter",false);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    private void initData() {
        mImageViewList = new ArrayList<ImageView>();
        for (int i=0;i<mImageIds.length;i++){
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(view);
            //每一页的灰点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.shape_point_gray);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i > 0)
                params.leftMargin = 10;
            point.setLayoutParams(params);
            llContainer.addView(point);
        }
    }

    private class GuideApater extends PagerAdapter{

        @Override
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = mImageViewList.get(position);
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
