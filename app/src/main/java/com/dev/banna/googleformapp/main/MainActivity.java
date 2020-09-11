package com.dev.banna.googleformapp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.dev.banna.googleformapp.R;
import com.dev.banna.googleformapp.google_form.GoogleFormActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager2 mViewPager2;

    MainPagerAdapter mPagerAdapter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTaps();
    }

    void initTaps() {
        mPagerAdapter = new MainPagerAdapter(this);
        mPagerAdapter.setItemCount(2);

        mViewPager2.setAdapter(mPagerAdapter);

        new TabLayoutMediator(mTabLayout, mViewPager2,
                (tab, position) -> {

                    if (position == 0)
                        tab.setText(R.string.hours);
                    else if (position == 1)
                        tab.setText(R.string.skills);

                }).attach();
    }

    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
        startActivity(GoogleFormActivity.getStartIntent(this));
    }


}