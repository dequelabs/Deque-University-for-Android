package com.dequesystems.accessibility101.important;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.dequesystems.a11yframework.LoggingAccessibilityDelegate;
import com.dequesystems.accessibility101.R;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;

import org.w3c.dom.Text;

/**
 * Created by chrismcmeeking on 10/8/15.
 */
public class FragmentImportantFixed extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_fixed, container, false);

        View topDemoContent = view.findViewById(R.id.demoContent);

        TextView topDemoHeading = (TextView) view.findViewById(R.id.aac_important_fixed_heading_top);

        Switch switchRed = (Switch) view.findViewById(R.id.switchRed);
        Switch switchBlue = (Switch) view.findViewById(R.id.switchBlue);
        Switch switchGreen = (Switch) view.findViewById(R.id.switchGreen);

        TextView textViewOne = (TextView) view.findViewById(R.id.aac_switch_label_one_top);
        TextView textViewTwo = (TextView) view.findViewById(R.id.aac_switch_label_two_top);
        TextView textViewThree = (TextView) view.findViewById(R.id.aac_switch_label_three_top);

        SwitchListener topSwitchListener = new SwitchListener(topDemoContent, switchRed, switchBlue, switchGreen);

        switchRed.setOnCheckedChangeListener(topSwitchListener);
        switchBlue.setOnCheckedChangeListener(topSwitchListener);
        switchGreen.setOnCheckedChangeListener(topSwitchListener);

        textViewOne.setContentDescription(textViewOne.getText() + ", " + topDemoHeading.getText());
        textViewThree.setContentDescription(textViewThree.getText() + ", " + topDemoHeading.getText());
        textViewTwo.setContentDescription(textViewTwo.getText() + ", " + topDemoHeading.getText());

        View bottomDemoContent = view.findViewById(R.id.demoContent2);
        TextView bottomHeading = (TextView) view.findViewById(R.id.aac_important_fixed_heading_bottom);
        Switch bottomSwitchRed = (Switch) view.findViewById(R.id.switchRed2);
        Switch bottomSwitchBlue = (Switch) view.findViewById(R.id.switchBlue2);
        Switch bottomSwitchGreen = (Switch) view.findViewById(R.id.switchGreen2);


        bottomSwitchRed.setContentDescription(bottomHeading.getText());
        bottomSwitchBlue.setContentDescription(bottomHeading.getText());
        bottomSwitchGreen.setContentDescription(bottomHeading.getText());

        SwitchListener bottomSwitchListener = new SwitchListener(bottomDemoContent, bottomSwitchRed, bottomSwitchBlue, bottomSwitchGreen);

        bottomSwitchRed.setOnCheckedChangeListener(bottomSwitchListener);
        bottomSwitchBlue.setOnCheckedChangeListener(bottomSwitchListener);
        bottomSwitchGreen.setOnCheckedChangeListener(bottomSwitchListener);

        return view;
    }

    class SwitchListener implements CompoundButton.OnCheckedChangeListener {

        final Switch mSwitchRed;
        final Switch mSwitchBlue;
        final Switch mSwitchGreen;
        final View mView;

        SwitchListener(View contentView, Switch switchRed, Switch switchBlue, Switch switchGreen) {
            mSwitchRed = switchRed;
            mSwitchBlue = switchBlue;
            mSwitchGreen = switchGreen;
            mView = contentView;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            boolean isRed = mSwitchRed.isChecked();
            boolean isGreen = mSwitchGreen.isChecked();
            boolean isBlue = mSwitchBlue.isChecked();

            mView.setBackgroundColor(LabelsBrokenFragment.getBackgroundColor(isRed, isGreen, isBlue));
        }
    }
}
