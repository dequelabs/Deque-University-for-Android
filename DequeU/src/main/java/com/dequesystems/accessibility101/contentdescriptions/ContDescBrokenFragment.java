package com.dequesystems.accessibility101.contentdescriptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

public class ContDescBrokenFragment extends Fragment {

    View mImageViewCat;

    private TextView mTextView1;
    private TextView mTextView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cont_desc_broken, container, false);

        mTextView1 = (TextView) view.findViewById(R.id.aac_cont_desc_link_view_1);
        mTextView2 = (TextView) view.findViewById(R.id.aac_cont_desc_link_view_2);

        mTextView1.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView2.setMovementMethod(LinkMovementMethod.getInstance());

        mImageViewCat = view.findViewById(R.id.aac_contDescBroken_imageViewCat);
        /*
        // #DEMO: Adding a content desciption to the cat image.
        mImageViewCat.setContentDescription(getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc));
        */
        return view;
    }
}
