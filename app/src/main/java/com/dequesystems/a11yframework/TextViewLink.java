package com.dequesystems.a11yframework;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by melinda.kothbauer@deque.com on 5/22/15.
 *
 * Framework class that makes hyperlinks accessible by adding the word, "link" to a textview's content description
 * Can be implemented by using this class rather than a TextView in xml layout files.
 *
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
        return super.getText() + ", link";
    }

}
