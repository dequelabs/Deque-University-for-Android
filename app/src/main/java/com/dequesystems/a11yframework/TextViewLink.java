package com.dequesystems.a11yframework;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by melindakothbauer on 5/22/15.
 */


public class TextViewLink extends TextView {

    public TextViewLink (Context context) {
       super(context);
    }

    public TextViewLink (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewLink (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public CharSequence getContentDescription() {
        CharSequence contentDescription = super.getText() + ", link";
        return contentDescription;
    }

}
