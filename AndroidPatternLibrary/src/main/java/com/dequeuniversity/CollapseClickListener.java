package com.dequeuniversity;

import android.view.View;
import android.widget.TextView;

public class CollapseClickListener implements View.OnClickListener {

  private final static String COLLAPSIBLE_TAG = "collapsible";

  private TextView textView;

  CollapseClickListener(final TextView textView){
    this.textView = textView;
  }

  @Override
  public void onClick(View view) {
      if(textView.getVisibility() == View.GONE) {
        view.setBackgroundResource(R.drawable.opened);
        view.setContentDescription("@string/collapsible_content_description_open");
        textView.setVisibility(View.VISIBLE);
      } else {
        view.setContentDescription("@string/collapsible_content_description_closed");
        view.setBackgroundResource(R.drawable.closed);
        textView.setVisibility(View.GONE);

      }
    }
  }
