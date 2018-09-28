package com.dequeuniversity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FrameNestedActiveElements extends RuleFrame {

    @Override
    public void setListeners(FrameLayout frameLayout) {
        final View button1 = frameLayout.findViewById(R.id.nested_elements_collapsible_button1);
        final View button2 = frameLayout.findViewById(R.id.nested_elements_collapsible_button2);
        final View button3 = frameLayout.findViewById(R.id.nested_elements_collapsible_button3);
        final View button4 = frameLayout.findViewById(R.id.nested_elements_collapsible_button4);
        final TextView textView1 = (TextView) frameLayout.findViewById(R.id.nested_elements_help_view1);
        final TextView textView2 = (TextView) frameLayout.findViewById(R.id.nested_elements_help_view2);
        final TextView textView3 = (TextView) frameLayout.findViewById(R.id.nested_elements_help_view3);
        final TextView textView4 = (TextView) frameLayout.findViewById(R.id.nested_elements_help_view4);

        button1.setOnClickListener(new CollapseClickListener(textView1));
        button2.setOnClickListener(new CollapseClickListener(textView2));
        button3.setOnClickListener(new CollapseClickListener(textView3));
        button4.setOnClickListener(new CollapseClickListener(textView4));
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_nested_elements;
    }
}
