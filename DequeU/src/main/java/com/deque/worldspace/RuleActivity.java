package com.deque.worldspace;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.deque.accessibilityanalyzer.R;
import com.deque.rulestubs.Rule;
import com.deque.rulestubs.RuleActiveViews;
import com.deque.rulestubs.RuleColorContrast;
import com.deque.rulestubs.RuleEditText;
import com.deque.rulestubs.RuleImageViews;
import com.deque.rulestubs.RuleInformativeViews;
import com.deque.rulestubs.RuleLabels;
import com.deque.rulestubs.RuleNestedActiveElement;
import com.deque.rulestubs.RuleTouchTargetSize;
import com.dequeuniversity.FrameActiveViews;
import com.dequeuniversity.FrameColorContrast;
import com.dequeuniversity.FrameEditTextViews;
import com.dequeuniversity.FrameImageViews;
import com.dequeuniversity.FrameInformativeViews;
import com.dequeuniversity.FrameLabels;
import com.dequeuniversity.FrameNestedActiveElements;
import com.dequeuniversity.FrameTouchTargetSize;
import com.dequeuniversity.RuleFrame;

import java.util.HashMap;

public class RuleActivity extends AppCompatActivity {

    private static final HashMap<String, RuleFrame> DEMO_MAPPING = new HashMap<>();
    private static final String RULE_NAME = "rule name";
    private static final int RULE_WORD_LENGTH = 4;

    static {
        DEMO_MAPPING.put(RuleTouchTargetSize.class.getName(), new FrameTouchTargetSize());
        DEMO_MAPPING.put(RuleEditText.class.getName(), new FrameEditTextViews());
        DEMO_MAPPING.put(RuleLabels.class.getName(), new FrameLabels());
        DEMO_MAPPING.put(RuleActiveViews.class.getName(), new FrameActiveViews());
        DEMO_MAPPING.put(RuleInformativeViews.class.getName(), new FrameInformativeViews());
        DEMO_MAPPING.put(RuleImageViews.class.getName(), new FrameImageViews());
        DEMO_MAPPING.put(RuleNestedActiveElement.class.getName(), new FrameNestedActiveElements());
        DEMO_MAPPING.put(RuleColorContrast.class.getName(), new FrameColorContrast());
    }

    public static Intent newInstance(Context context, Class<? extends Rule> ruleClass) throws IllegalAccessException, InstantiationException {
        Intent intent = new Intent(context, RuleActivity.class);
        intent.putExtra(RULE_NAME, ruleClass.newInstance());
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        if (getIntent() != null && getIntent().getSerializableExtra(RULE_NAME) != null) {
            Rule rule = (Rule) getIntent().getSerializableExtra(RULE_NAME);
            updateTitle(rule);
            setRuleText(rule);
            loadDemo(rule);
        }
    }

    private void updateTitle(Rule rule) {
        String removeWordRule = rule.getClass().getSimpleName().substring(RULE_WORD_LENGTH);
        String addSpaceOnCamelCase = removeWordRule.replaceAll("\\d", "")
                                                   .replaceAll("([A-Z])", " $1");
        setTitle(addSpaceOnCamelCase);
    }

    private void setRuleText(Rule rule) {
        TextView textView = (TextView) findViewById(R.id.textViewRuleDescription);
        textView.setText(rule.description);

        textView = (TextView) findViewById(R.id.textViewImportance);
        textView.setText(rule.importance);
    }

    private void loadDemo(Rule rule) {
        final ScrollView mainContainer = (ScrollView) findViewById(R.id.rule_activity);
        final String ruleName = rule.getClass().getName();
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        final RuleFrame ruleFrame = DEMO_MAPPING.get(ruleName);

        frameLayout.removeAllViews();
        frameLayout.addView(LayoutInflater.from(this).inflate(ruleFrame.getLayoutId(), mainContainer, false));
        ruleFrame.setListeners(frameLayout);
        ruleFrame.preventInitialFocus(this);
    }
}
