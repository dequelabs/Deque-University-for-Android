package com.dequeuniversity;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class FrameLabels extends RuleFrame {
    @Override
    public void setListeners(FrameLayout frameLayout) {
        final ImageButton button1 = (ImageButton) frameLayout.findViewById(R.id.labels_collapsible_button1);
        final ImageButton button2 = (ImageButton) frameLayout.findViewById(R.id.labels_collapsible_button2);
        final ImageButton button3 = (ImageButton) frameLayout.findViewById(R.id.labels_collapsible_button3);
        final TextView textView1 = (TextView) frameLayout.findViewById(R.id.control_labels_help_view1);
        final TextView textView2 = (TextView) frameLayout.findViewById(R.id.control_labels_help_view2);
        final TextView textView3 = (TextView) frameLayout.findViewById(R.id.control_labels_help_view3);

        button1.setOnClickListener(new CollapseClickListener(textView1));
        button2.setOnClickListener(new CollapseClickListener(textView2));
        button3.setOnClickListener(new CollapseClickListener(textView3));
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_labels;
    }
}
