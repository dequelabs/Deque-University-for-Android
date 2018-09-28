package com.dequeuniversity;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class FrameEditTextViews extends RuleFrame {

    @Override
    public void setListeners(FrameLayout frameLayout) {
        final ImageButton button1 = (ImageButton) frameLayout.findViewById(R.id.edit_text_collapsible_button1);
        final ImageButton button2 = (ImageButton) frameLayout.findViewById(R.id.edit_text_collapsible_button2);
        final TextView textView1 = (TextView) frameLayout.findViewById(R.id.edit_text_help_view1);
        final TextView textView2 = (TextView) frameLayout.findViewById(R.id.edit_text_help_view2);

        button1.setOnClickListener(new CollapseClickListener(textView1));
        button2.setOnClickListener(new CollapseClickListener(textView2));
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_edit_text;
    }
}
