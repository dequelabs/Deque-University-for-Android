package com.dequesystems.accessibility101.contentdescriptions;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dequesystems.accessibility101.R;

public class ContDescBrokenFragment extends Fragment {

    View mImageViewCat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cont_desc_broken, container, false);

        mImageViewCat = view.findViewById(R.id.aac_contDescBroken_imageViewCat);
        /*
        // #DEMO: Adding a content desciption to the cat image.
        mImageViewCat.setContentDescription(getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc));
        */
        return view;
    }
}
