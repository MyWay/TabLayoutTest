package com.example.tablayout.tablayouttesting;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.commonsware.cwac.pager.PageDescriptor;
import com.commonsware.cwac.pager.SimplePageDescriptor;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    private ArrayList<PageDescriptor> mPages;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        addTabs();
        mAdapter = new MyPagerAdapter(getFragmentManager(), mPages);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.pager_header);
        if (mPager != null) {
            mPager.setAdapter(mAdapter);
            if (mTabLayout != null) {
                mTabLayout.setupWithViewPager(mPager);
            }
        }
    }

    public void addTabs() {
        mPages = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            mPages.add(new SimplePageDescriptor("test" + i, "test" + i));
    }

    public MyPagerAdapter getAdapter() {
        return mAdapter;
    }
}
