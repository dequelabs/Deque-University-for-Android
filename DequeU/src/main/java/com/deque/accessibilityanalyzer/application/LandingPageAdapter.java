package com.deque.accessibilityanalyzer.application;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deque.accessibilityanalyzer.R;
import com.deque.rulestubs.RuleActiveViews;
import com.deque.rulestubs.RuleColorContrast;
import com.deque.rulestubs.RuleEditText;
import com.deque.rulestubs.RuleImageViews;
import com.deque.rulestubs.RuleInformativeViews;
import com.deque.rulestubs.RuleLabels;
import com.deque.rulestubs.RuleNestedActiveElement;
import com.deque.rulestubs.RuleTouchTargetSize;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

public class LandingPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<LandingPageItem> items = new ArrayList<>();

    LandingPageAdapter(Context context) {
        this.context = context;

        items.add(new LandingPageHeader(context, R.string.header_title_rule_demos, R.string.header_body_rule_demos));
        items.add(new LandingPageLauncher(context, R.string.item_title_active_views, R.drawable.ic_active_views, RuleActiveViews.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_color_contrast, R.drawable.ic_color_contrast, RuleColorContrast.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_edit_text, R.drawable.ic_edit_text, RuleEditText.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_image_views, R.drawable.ic_image_views, RuleImageViews.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_informative_views, R.drawable.ic_informative_controls, RuleInformativeViews.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_labels, R.drawable.ic_labels, RuleLabels.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_nested_active_elements, R.drawable.ic_nested_active_elements, RuleNestedActiveElement.class));
        items.add(new LandingPageLauncher(context, R.string.item_title_touch_target_size, R.drawable.ic_touch_target_size, RuleTouchTargetSize.class));
        items.add(new LandingPageHeader(context, R.string.header_title_accessibility_tools, R.string.header_body_accessibility_tools));
        items.add(new LandingPageLauncher(context, R.string.item_title_talkback, R.drawable.aac_non_sighted_icon, TalkBackAboutActivity.class));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        switch (viewType) {
            case ItemTypes.HEADER:
                view = inflater.inflate(R.layout.item_section_heading, parent, false);
                return new HeaderViewHolder(view);
            case ItemTypes.LINK:
                view = inflater.inflate(R.layout.item_demo_link, parent, false);
                return new LinkViewHolder(view);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ItemTypes.HEADER) {
            HeaderViewHolder vh = (HeaderViewHolder) holder;
            LandingPageHeader header = (LandingPageHeader) items.get(position);

            vh.title.setText(header.getTitle());
            vh.body.setText(header.getBody());
            vh.body.setVisibility(VISIBLE);
        } else {
            LinkViewHolder vh = (LinkViewHolder) holder;
            LandingPageLauncher launcher = (LandingPageLauncher) items.get(position);

            vh.text.setText(launcher.getTitle());
            vh.text.setOnClickListener(launcher.launch());
            vh.imageView.setBackground(ContextCompat.getDrawable(context, launcher.getImage()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof LandingPageHeader) {
            return ItemTypes.HEADER;
        } else {
            return ItemTypes.LINK;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getSpanSize(int position) {
        switch (getItemViewType(position)) {
            case ItemTypes.HEADER:
                return 2;
            case ItemTypes.LINK:
                return 1;
            default:
                throw new UnsupportedOperationException();
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;

        HeaderViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.heading_text);
            body = (TextView) itemView.findViewById(R.id.body_text);
        }
    }

    class LinkViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView imageView;

        LinkViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.page_text);
            imageView = (ImageView) itemView.findViewById(R.id.page_image);
        }
    }

    private static class ItemTypes {
        static final int HEADER = 0;
        static final int LINK = 1;
    }
}
