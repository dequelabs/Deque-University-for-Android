package com.dequesystems.accessibility101.introduction;

import android.os.Bundle;
import android.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

public class AppIntroductionFragment extends Fragment {

    View mView;

    TextView mTextView1;
    TextView mTextView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_app_introduction, container, false);

        mTextView1 = (TextView) mView.findViewById(R.id.aacTextView1);
        mTextView2 = (TextView) mView.findViewById(R.id.aacTextView2);

        mTextView1.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView2.setMovementMethod(LinkMovementMethod.getInstance());

        return mView;
    }
}
