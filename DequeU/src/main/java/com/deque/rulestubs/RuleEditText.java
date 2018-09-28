package com.deque.rulestubs;

public class RuleEditText extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.BEST_PRACTICE;

    public RuleEditText() {
        super("The entered text in editable views, as well as its purpose, must be available to screen reader users.",
                "Looks at all EditText views and ensures they do not have a contentDescription. EditText views also require an associated visible label, which is ensured by the Labels rule.",
                "Editable views contain a lot of information that can be acted upon. Screen reader users must be able to know what text is entered in them, and what the purpose of that input is.\n\nIt is good practice to share information in the hint attribute of EditText views. However, on older devices this information is temporary and disappears once text is entered. Content descriptions are another obvious source of this information, but, content descriptions will either override the user entered text or be ignored by TalkBack completely.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/edittext-controls");
    }
}
