package com.dequesystems.accessibility101.edittexts;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFixedFragment extends Fragment {

    public EditTextFixedFragment() {
        // Required empty public constructor
    }

    TextView mTextView;
    EditText mEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text_fixed, container, false);
        mTextView = (TextView) view.findViewById(R.id.aac_edit_text_fixed_heading_1);
        mEditText = (EditText) view.findViewById(R.id.aac_edit_text_fixed_edit_text_1);
        mEditText.clearFocus();
        return view;
    }

    @Override
    public void onResume() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getActivity().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()){
            mTextView.setFocusable(true);
            mTextView.setFocusableInTouchMode(true);
            mTextView.requestFocus();
        }
        super.onResume();
    }
}
