package com.dequesystems.accessibility101.important;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dequesystems.accessibility101.R;

/**
 * Created by chrismcmeeking on 10/8/15.
 */
public class FragmentImportantFixed extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_important_fixed, container, false);

        return mainView;
    }
}
