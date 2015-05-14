package com.dequesystems.accessibility101.edittexts;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text_about, container, false);
        mTextView1 = (TextView) view.findViewById(R.id.aac_edit_text_about_heading_1);
        return view;
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
