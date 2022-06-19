package com.dedsec.materialui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dedsec.materialui.activity.HomeActivity;
import com.dedsec.materialui.adapter.SlideAdapter;

public class SliderActivity extends AppCompatActivity {

    private LinearLayout mDotsLayout;
    private ViewPager mViewPager;
    private SlideAdapter mAdapter;
    Context mContext;

    // list of dots for slide
    private TextView[] mDots;

    private ImageButton _btnNext, _btnBack;
    private Button _btnGetStarted;
    private Animation _popUpAnim, _tapAnim;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_slider);
        mContext = this;

        _btnNext = findViewById(R.id.next_btn);
        _btnBack = findViewById(R.id.back_btn);
        _btnGetStarted = findViewById(R.id.getStarted_btn);
        _popUpAnim = AnimationUtils.loadAnimation(mContext, R.anim.getstarted_btn_popup);
        _tapAnim = AnimationUtils.loadAnimation(mContext, R.anim.btn_tap);

        mViewPager = findViewById(R.id.view_pager);
        mDotsLayout = findViewById(R.id.dots_layout);

        mAdapter = new SlideAdapter(mContext);
        mViewPager.setAdapter(mAdapter);

        addDotsIndicator(0);
        mViewPager.addOnPageChangeListener(viewListener);

        // OnClickListener for NEXT & BACK & GETSTARTED Button--
        _btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        _btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //_btnGetStarted.startAnimation(_tapAnim);
                Intent homeIntent = new Intent(mContext, HomeActivity.class);
                startActivity(homeIntent);
                finish();

            }
        });
    }

    // onStartMethod For Dots Indicator
    private void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentBlack));

            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.dotsSelected));
        }

    }


    // Method For onScroll Page Listener
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;

            if (position == 0) {

                _btnGetStarted.setEnabled(false);
                _btnNext.setEnabled(true);
                _btnBack.setEnabled(false);
                _btnNext.setVisibility(View.VISIBLE);
                _btnBack.setVisibility(View.INVISIBLE);
                _btnGetStarted.setVisibility(View.INVISIBLE);
                _btnGetStarted.setText("");

            } else if (position == mDots.length - 1) {

                _btnGetStarted.setEnabled(true);
                _btnGetStarted.startAnimation(_popUpAnim);
                _btnNext.setEnabled(true);
                _btnBack.setEnabled(true);
                _btnNext.setVisibility(View.INVISIBLE);
                _btnBack.setVisibility(View.VISIBLE);
                _btnGetStarted.setVisibility(View.VISIBLE);
                _btnGetStarted.setText("GET STARTED");

            } else {

                _btnGetStarted.setEnabled(false);
                _btnNext.setEnabled(true);
                _btnBack.setEnabled(true);
                _btnNext.setVisibility(View.VISIBLE);
                _btnBack.setVisibility(View.VISIBLE);
                _btnGetStarted.setVisibility(View.INVISIBLE);
                _btnGetStarted.setText("");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
