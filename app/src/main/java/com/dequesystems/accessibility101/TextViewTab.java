package com.dequesystems.accessibility101;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by melindakothbauer on 5/22/15.
 */
public class TextViewTab extends TextView {

    public TextViewTab (Context context) {
        super(context);
    }

    public TextViewTab (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewTab (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public CharSequence getContentDescription() {
        CharSequence contentDescription = super.getText() + ", tab";
        return contentDescription;
    }

}
