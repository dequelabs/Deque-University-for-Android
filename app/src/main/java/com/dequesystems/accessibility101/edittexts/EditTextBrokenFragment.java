package com.dequesystems.accessibility101.edittexts;


import android.os.Bundle;
import android.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextBrokenFragment extends Fragment {

    EditText mEditText;
    TextView mTextView;

    TextView mTextViewLink1;
    TextView mTextViewLink2;

    public EditTextBrokenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text_broken, container, false);

        mTextViewLink1 = (TextView) view.findViewById(R.id.aac_edit_text_link_view_1);
        mTextViewLink2 = (TextView) view.findViewById(R.id.aac_edit_text_link_view_2);

        mTextViewLink1.setMovementMethod(LinkMovementMethod.getInstance());
        mTextViewLink2.setMovementMethod(LinkMovementMethod.getInstance());

        mEditText = (EditText) view.findViewById(R.id.aac_editTextBroken_editText1);
        mTextView = (TextView) view.findViewById(R.id.aac_editTextBroken_textView1);
        /*
        // #DEMO: Associate the EditText with it's visible label using the labelFor attribute.
        mTextView.setLabelFor(mEditText.getId());
        */
        return view;
    }


}
