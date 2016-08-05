package com.example.tablayout.tablayouttesting;

import android.app.Fragment;
import android.os.Bundle;

public class MyFragment extends Fragment {
    private static final String KEY_TITLE = "title";

    public static MyFragment newInstance(String sTitle) {
        MyFragment mFragment = new MyFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, sTitle);
        mFragment.setArguments(args);

        return mFragment;
    }

    public String getTitle() {
        return(getArguments().getString(KEY_TITLE));
    }
}
