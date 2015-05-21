package com.dequesystems.accessibility101.edittexts;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextAboutFragment extends Fragment {

    public EditTextAboutFragment() {
        // Required empty public constructor
    }

    TextView mTextView1;

    View mView;

    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_edit_text_about, container, false);

        mTextView1 = (TextView) mView.findViewById(R.id.aac_edit_text_about_heading_1);

        mTextView2 = (TextView) mView.findViewById(R.id.aacEditTextTextView1);
        mTextView3 = (TextView) mView.findViewById(R.id.aacEditTextTextView2);
        mTextView4 = (TextView) mView.findViewById(R.id.aacEditTextTextView3);
        mTextView5 = (TextView) mView.findViewById(R.id.aacEditTextTextView4);
        mTextView6 = (TextView) mView.findViewById(R.id.aacEditTextTextView5);

        mTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView3.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView4.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView5.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView6.setMovementMethod(LinkMovementMethod.getInstance());

        int linkColor = getResources().getColor(R.color.aac_text_link);

        mTextView2.setLinkTextColor(linkColor);
        mTextView3.setLinkTextColor(linkColor);
        mTextView4.setLinkTextColor(linkColor);
        mTextView5.setLinkTextColor(linkColor);
        mTextView6.setLinkTextColor(linkColor);

        return mView;
    }

    @Override
    public void onResume() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getActivity().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            mTextView1.setFocusable(true);
            mTextView1.setFocusableInTouchMode(true);
            mTextView1.requestFocus();
        }
        super.onResume();
    }
}
