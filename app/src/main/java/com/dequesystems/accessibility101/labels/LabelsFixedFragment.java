package com.dequesystems.accessibility101.labels;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.dequesystems.accessibility101.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LabelsFixedFragment extends Fragment {

    private View mViewDemoContent;

    private Switch mSwitchRed;
    private Switch mSwitchGreen;
    private Switch mSwitchBlue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_labels_fixed, container, false);

        mViewDemoContent = mView.findViewById(R.id.demoContent);

        mSwitchRed = (Switch) mView.findViewById(R.id.switchRed);
        mSwitchGreen = (Switch) mView.findViewById(R.id.switchGreen);
        mSwitchBlue = (Switch) mView.findViewById(R.id.switchBlue);

        mSwitchRed.setOnCheckedChangeListener(mSwitchListener);
        mSwitchGreen.setOnCheckedChangeListener(mSwitchListener);
        mSwitchBlue.setOnCheckedChangeListener(mSwitchListener);

        return mView;
    }

    CompoundButton.OnCheckedChangeListener mSwitchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            boolean isRed = mSwitchRed.isChecked();
            boolean isGreen = mSwitchGreen.isChecked();
            boolean isBlue = mSwitchBlue.isChecked();

            mViewDemoContent.setBackgroundColor(LabelsBrokenFragment.getBackgroundColor(isRed, isGreen, isBlue));
        }
    };
}
