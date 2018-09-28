package com.deque.rulestubs;

public class RuleNestedActiveElement extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.WCAG20_2_1_1;

    protected RuleNestedActiveElement() {
        super("All active elements must be individually focusable by TalkBack in order for users to interact with them.",
                "Active views nested within containers must be the only active views in that container.",
                "If there are active views on the screen that cannot receive focus it will be difficult for those using Touch To Explore features of TalkBack. Users may not understands why those views are not actionable.\n\nWhile grouping informative views into one TalkBack focusable container may be useful, nesting active controls together is not. Particularly when we consider other assistive technologies like \"Touch To Speak\" and \"Switch Access\".",
                successCriteria,
                "http://www.google.com");

    }
}
