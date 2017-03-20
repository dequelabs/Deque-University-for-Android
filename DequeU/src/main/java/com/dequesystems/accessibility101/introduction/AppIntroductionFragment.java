package com.dequesystems.accessibility101.introduction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

public class AppIntroductionFragment extends Fragment {

    View mView;

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_app_introduction, container, false);

        mTextView1 = (TextView) mView.findViewById(R.id.aacIntroTextView1);
        mTextView2 = (TextView) mView.findViewById(R.id.aacIntroTextView2);
        mTextView3 = (TextView) mView.findViewById(R.id.aacIntroTextView3);

        mTextView1.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView3.setMovementMethod(LinkMovementMethod.getInstance());

        int linkColor = getResources().getColor(R.color.aac_text_link);

        mTextView1.setLinkTextColor(linkColor);
        mTextView2.setLinkTextColor(linkColor);
        mTextView3.setLinkTextColor(linkColor);

        return mView;
    }
}
