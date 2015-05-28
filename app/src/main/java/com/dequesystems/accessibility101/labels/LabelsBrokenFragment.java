package com.dequesystems.accessibility101.labels;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

public class LabelsBrokenFragment extends Fragment {

    private View mView;
    private View mViewDemoContent;

    private Switch mSwitchRed;
    private Switch mSwitchGreen;
    private Switch mSwitchBlue;

    private TextView mLabelForRed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_labels_broken, container, false);

        mViewDemoContent = mView.findViewById(R.id.demoContent);

        mSwitchRed = (Switch) mView.findViewById(R.id.switchRed);
        mSwitchGreen = (Switch) mView.findViewById(R.id.switchGreen);
        mSwitchBlue = (Switch) mView.findViewById(R.id.switchBlue);
        /*
        // #DEMO: Associate the red switch with it's visible label using the labelFor attribute.
        mLabelForRed = (TextView) mView.findViewById(R.id.labelRed);
        mSwitchRed.setLabelFor(mSwitchRed.getId());
        */
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

            mViewDemoContent.setBackgroundColor(getBackgroundColor(isRed, isGreen, isBlue));
        }
    };

    public static int getBackgroundColor(boolean isRed, boolean isGreen, boolean isBlue) {

        int red = isRed ? 255 : 0;
        int green = isGreen ? 255 : 0;
        int blue = isBlue ? 255 : 0;

        return Color.rgb(red, green, blue);
    }
}
