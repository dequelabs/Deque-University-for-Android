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

    View mTopLayout;
    TextView mTopHeading;
    Switch mTopSwitch1;
    Switch mTopSwitch2;
    Switch mTopSwitch3;


    Switch mBottomSwitch1;
    Switch mBottomSwitch2;
    Switch mBottomSwitch3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_fixed, container, false);

        mTopLayout = view.findViewById(R.id.aacImportantLayoutTopMain);
        mTopHeading = (TextView) view.findViewById(R.id.aacImportantTopHeadingMain);
        mTopSwitch1 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting1);
        mTopSwitch2 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting2);
        mTopSwitch3 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting3);

        String contentDescription = "";

        contentDescription += mTopHeading.getText();
        contentDescription += getTextFromLayout((ViewGroup)mTopSwitch1.getParent());
        contentDescription += getTextFromLayout((ViewGroup)mTopSwitch2.getParent());
        contentDescription += getTextFromLayout((ViewGroup)mTopSwitch3.getParent());

        mTopLayout.setContentDescription(contentDescription);

        View bottomDemoContent = view.findViewById(R.id.aacImportantLayoutBottomMain);
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

    String getTextFromLayout(ViewGroup viewGroup) {

        if (viewGroup.getContentDescription() != null) return viewGroup.getContentDescription().toString();

        String result = "";

        for (int i = 0; i < viewGroup.getChildCount(); ++i) {
            View childView = viewGroup.getChildAt(i);

            if (childView instanceof ViewGroup) {
                result += getTextFromLayout((ViewGroup)childView);
            }

            if (childView instanceof TextView) {
                result += " " + ((TextView) childView).getText();
            }

            if (childView instanceof Switch) {
                Switch childSwitch = (Switch)childView;

                if (childSwitch.isChecked()) {
                    result += " switch, on";
                } else {
                    result += " switch, off";
                }
            }
        }

        return result;
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
