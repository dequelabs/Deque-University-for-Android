package com.dequesystems.accessibility101.edittexts;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFixedFragment extends Fragment {

    public EditTextFixedFragment() {
        // Required empty public constructor
    }

    TextView textView;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text_fixed, container, false);
        textView = (TextView) view.findViewById(R.id.aac_edit_text_fixed_heading_1);
        editText = (EditText) view.findViewById(R.id.aac_edit_text_fixed_edit_text_1);
        editText.clearFocus();
        return view;
    }

    @Override
    public void onResume() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getActivity().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()){
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.requestFocus();
        }
        super.onResume();
    }
}
