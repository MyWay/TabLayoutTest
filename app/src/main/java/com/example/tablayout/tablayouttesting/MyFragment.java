package com.example.tablayout.tablayouttesting;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyFragment extends Fragment {
    private static final String KEY_TITLE = "title";
    private TextView mTextView;

    public static MyFragment newInstance(String sTitle) {
        MyFragment mFragment = new MyFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, sTitle);
        mFragment.setArguments(args);

        return mFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment, container, false);
        mTextView = (TextView) mView.findViewById(R.id.textView);
        mTextView.setText(getTitle());

        return mView;
    }

    public String getTitle() {
        return(getArguments().getString(KEY_TITLE));
    }
}
