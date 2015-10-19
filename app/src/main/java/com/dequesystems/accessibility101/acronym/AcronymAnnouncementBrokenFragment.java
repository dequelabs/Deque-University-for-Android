package com.dequesystems.accessibility101.acronym;


import android.os.Bundle;
import android.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcronymAnnouncementBrokenFragment extends Fragment {

    private TextView mTextView;

    public AcronymAnnouncementBrokenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acronym_announcement_broken, container, false);

        mTextView = (TextView) view.findViewById(R.id.aac_acronym_annoucement_link_view);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());


        return view;
    }


}
