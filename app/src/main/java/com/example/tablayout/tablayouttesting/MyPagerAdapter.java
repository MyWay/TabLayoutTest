package com.example.tablayout.tablayouttesting;

import android.app.Fragment;
import android.app.FragmentManager;

import com.commonsware.cwac.pager.ArrayPagerAdapter;
import com.commonsware.cwac.pager.PageDescriptor;

import java.util.ArrayList;

class MyPagerAdapter extends ArrayPagerAdapter {
    MyPagerAdapter(FragmentManager mgr, ArrayList<PageDescriptor> descriptors) {
        super(mgr, descriptors);
    }

    @Override
    protected Fragment createFragment(PageDescriptor pageDescriptor) {
        String sTitle = pageDescriptor.getTitle();

        return MyFragment.newInstance(sTitle);
    }
}
