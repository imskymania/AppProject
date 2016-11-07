package com.word.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TabHost;

import java.util.List;
import java.util.Vector;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        pager = (ViewPager) findViewById(R.id.viewpager);
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Tab1.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab2.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab3.class.getName()));
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        pager.setAdapter(adapter);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("단어",
                getResources().getDrawable(R.drawable.abc_ic_menu_copy_mtrl_am_alpha)),
                Tab1.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("문장",
                getResources().getDrawable(R.drawable.abc_ic_menu_share_mtrl_alpha)),
                Tab2.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("추가",
                getResources().getDrawable(R.drawable.abc_ic_voice_search_api_mtrl_alpha)),
                Tab3.class, null);

        mTabHost.getTabWidget().getChildAt(0).setOnClickListener(tabClick);
        mTabHost.getTabWidget().getChildAt(1).setOnClickListener(tabClick);
        mTabHost.getTabWidget().getChildAt(2).setOnClickListener(tabClick);


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                mTabHost.setCurrentTab(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }


        });
    }//end of onCreate

    View.OnClickListener tabClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == mTabHost.getTabWidget().getChildAt(0)) {
                pager.setCurrentItem(0);
            } else if (view == mTabHost.getTabWidget().getChildAt(1)) {
                pager.setCurrentItem(1);
            } else if (view == mTabHost.getTabWidget().getChildAt(2)) {
                pager.setCurrentItem(2);
            }
        }
    };

    public class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return this.fragments.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return this.fragments.size();
        }

    }


}