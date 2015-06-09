package com.dequesystems.accessibility101.acronym;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcronymAnnouncementAboutFragment extends Fragment {


    public AcronymAnnouncementAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acronym_announcement_about, container, false);
    }


}
