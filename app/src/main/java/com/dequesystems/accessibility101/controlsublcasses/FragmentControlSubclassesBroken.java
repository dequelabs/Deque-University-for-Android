package com.dequesystems.accessibility101.controlsublcasses;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dequesystems.accessibility101.R;

/**
 * Created by chrismcmeeking on 4/22/16.
 */
public class FragmentControlSubclassesBroken extends Fragment {

    private class MyButton extends Button {

        public MyButton(Context context) {
            super(context);
        }
    }

    private LinearLayout mContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control_subclasses_broken, container, false);

        mContainer = (LinearLayout) view.findViewById(R.id.container);

        ImageView brokenButton = new ImageView(getActivity());
        brokenButton.setPadding(0,0,0,0);
        brokenButton.setImageResource(android.R.drawable.btn_default);
        brokenButton.setContentDescription("Broken");
        brokenButton.setScaleType(ImageView.ScaleType.FIT_XY);

        Button fixedButton = new Button(getActivity());
        fixedButton.setBackgroundResource(android.R.drawable.btn_default);
        fixedButton.setContentDescription("Fixed");

        mContainer.addView(brokenButton);
        mContainer.addView(fixedButton);

        /*
        // #DEMO: Adding a content description to the cat image.
        mImageViewCat.setContentDescription(getResources().getString(R.string.aac_cont_desc_fixed_cat_cont_desc));
        */
        return view;
    }
}