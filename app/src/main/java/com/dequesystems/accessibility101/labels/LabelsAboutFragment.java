package com.dequesystems.accessibility101.labels;

import android.os.Bundle;
import android.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

import java.util.ArrayList;

public class LabelsAboutFragment extends Fragment {

    View mView;

    ArrayList<TextView> mLinkedTextViews;

    public LabelsAboutFragment() {
        mLinkedTextViews = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = inflater.inflate(R.layout.fragment_labels_about, container, false);


        mLinkedTextViews.add((TextView)mView.findViewById(R.id.aacTextView1));
        mLinkedTextViews.add((TextView)mView.findViewById(R.id.aacTextView2));
        mLinkedTextViews.add((TextView)mView.findViewById(R.id.aacTextView3));
        mLinkedTextViews.add((TextView)mView.findViewById(R.id.aacTextView4));

        for (TextView textView : mLinkedTextViews) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        return mView;
    }

}
