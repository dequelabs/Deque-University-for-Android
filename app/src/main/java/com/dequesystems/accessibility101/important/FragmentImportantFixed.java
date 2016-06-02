package com.dequesystems.accessibility101.important;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;
import com.dequesystems.accessibility101.labels.LabelsBrokenFragment;

/**
 * Created by chrismcmeeking on 10/8/15.
 */
public class FragmentImportantFixed extends Fragment{

    View mTopLayout;
    TextView mTopHeading;
    Switch mTopSwitch1;
    Switch mTopSwitch2;
    Switch mTopSwitch3;
    TextView mTopSwitchLabel1;
    TextView mTopSwitchLabel2;
    TextView mTopSwitchLabel3;

    View mBottomLayout;
    TextView mBottomHeading;
    Switch mBottomSwitch1;
    Switch mBottomSwitch2;
    Switch mBottomSwitch3;

    private static final String STRING_ROLE_SWITCH = "switch";
    private static final String STRING_STATE_ON = "on";
    private static final String STRING_STATE_OFF = "off";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_fixed, container, false);

        //First let's grab all of the views using their IDs from the xml layout.
        mTopLayout = view.findViewById(R.id.aacImportantLayoutTopMain);
        mTopHeading = (TextView) view.findViewById(R.id.aacImportantTopHeadingMain);
        mTopSwitch1 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting1);
        mTopSwitch2 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting2);
        mTopSwitch3 = (Switch) view.findViewById(R.id.aacImportantTopSwitchSetting3);
        mTopSwitchLabel1 = (TextView)view.findViewById(R.id.aacImportantTopTextViewSetting1);
        mTopSwitchLabel2 = (TextView)view.findViewById(R.id.aacImportantTopTextViewSetting2);
        mTopSwitchLabel3 = (TextView)view.findViewById(R.id.aacImportantTopTextViewSetting3);

        mBottomLayout = view.findViewById(R.id.aacImportantLayoutBottomMain);
        mBottomHeading = (TextView) view.findViewById(R.id.aacImportantBottomHeading);
        mBottomSwitch1 = (Switch) view.findViewById(R.id.aacImportantBottomSwitch1);
        mBottomSwitch2 = (Switch) view.findViewById(R.id.aacImportantBottomSwitch2);
        mBottomSwitch3 = (Switch) view.findViewById(R.id.aacImportantBottomSwitch3);

        //Now let's associate the heading, with the labels.  If we were to individually focus these labels, we would here
        //both the label and the heading.  However, the labels aren't individually focusable, because the layout is
        //important for accessibility.  So we will only hear this read out when they are read out as labels for our switches!
        mTopSwitchLabel1.setContentDescription(mTopSwitchLabel1.getText() + " " + mTopHeading.getText());
        mTopSwitchLabel2.setContentDescription(mTopSwitchLabel2.getText() + " " + mTopHeading.getText());
        mTopSwitchLabel3.setContentDescription(mTopSwitchLabel3.getText() + " " + mTopHeading.getText());

        //Now let's collect all of the information in the layout (switch label/role/state) and put it into one big label.
        String contentDescription = "";

        contentDescription += mTopHeading.getText();

        contentDescription += " " + mTopSwitchLabel1.getText();
        contentDescription += " " + STRING_ROLE_SWITCH + ", " + (mTopSwitch1.isChecked() ? STRING_STATE_ON : STRING_STATE_OFF);

        contentDescription += " " + mTopSwitchLabel2.getText();
        contentDescription += " " + STRING_ROLE_SWITCH + ", " + (mTopSwitch2.isChecked() ? STRING_STATE_ON : STRING_STATE_OFF);

        contentDescription += " " + mTopSwitchLabel3.getText();
        contentDescription += " " + STRING_ROLE_SWITCH + ", " + (mTopSwitch3.isChecked() ? STRING_STATE_ON : STRING_STATE_OFF);

        //With all of the information collected, we set this as the content description of the layout containing all of these controls
        mTopLayout.setContentDescription(contentDescription);

        //For the bottom layout, we're going to use a different technique.  In this case we have used the Switch's native text, rather
        //than our own text view.  Since the Switch's text gets read out by TalkBack regardless of whether it has a content description
        //or not, all we have to do is set our Switch's content descriptions to that of the main heading.
        mBottomSwitch1.setContentDescription(mBottomHeading.getText());
        mBottomSwitch2.setContentDescription(mBottomHeading.getText());
        mBottomSwitch3.setContentDescription(mBottomHeading.getText());

        //Now let's create and add switch listeners so that our buttons do something interesting!
        SwitchListener topSwitchListener = new SwitchListener(mTopLayout, mTopSwitch1, mTopSwitch2, mTopSwitch3);
        mTopSwitch1.setOnCheckedChangeListener(topSwitchListener);
        mTopSwitch2.setOnCheckedChangeListener(topSwitchListener);
        mTopSwitch3.setOnCheckedChangeListener(topSwitchListener);

        SwitchListener bottomSwitchListener = new SwitchListener(mBottomLayout, mBottomSwitch1, mBottomSwitch2, mBottomSwitch3);
        mBottomSwitch1.setOnCheckedChangeListener(bottomSwitchListener);
        mBottomSwitch2.setOnCheckedChangeListener(bottomSwitchListener);
        mBottomSwitch3.setOnCheckedChangeListener(bottomSwitchListener);

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
