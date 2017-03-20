package com.dequesystems.accessibility101.labels;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

public class LabelsBrokenFragment extends Fragment {

    private View mViewDemoContent;

    private TextView mTextView1;

    private Switch mSwitchRed;
    private Switch mSwitchGreen;
    private Switch mSwitchBlue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_labels_broken, container, false);

        mTextView1 = (TextView) mView.findViewById(R.id.aac_labels_link_view);

        mTextView1.setMovementMethod(LinkMovementMethod.getInstance());

        mViewDemoContent = mView.findViewById(R.id.demoContent);

        mSwitchRed = (Switch) mView.findViewById(R.id.switchRedBroken);
        mSwitchGreen = (Switch) mView.findViewById(R.id.switchGreenBroken);
        mSwitchBlue = (Switch) mView.findViewById(R.id.switchBlueBroken);


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
