package com.deque.rulestubs;

public class RuleInformativeViews extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.PLATFORM;

    public RuleInformativeViews() {
        super("Visible views that have speakable text must be focusable by assistive technologies.",
                "Any views that have speakable text must respond to Touch-To-Explore events. If a control cannot have the green TalkBack focus rectangle around it, this rule will fail.",
                "When designing for screen readers it is important to remember that we are not only concerned about blind users, but also sight impaired users. A low sighted user using TalkBack to explore the screen may find it awkward or confusing to drag their finger across a view that presents no information.\n\nNote that knowing that a view is disabled is important for accessibility users. If something is disabled, that implies there is a behavior that enables it, which is important information for the user.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/informative-control-focus");
    }
}
