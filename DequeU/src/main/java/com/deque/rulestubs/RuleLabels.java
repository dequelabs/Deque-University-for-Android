package com.deque.rulestubs;


public class RuleLabels extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.PLATFORM;

    public RuleLabels() {
        super("Views that have no \"Accessible Name\", a name conveyed by an accessibility view automatically, must be associated with an accessible TextView.",
                "Views that don't have their own accessible name must be associated with a visible label. This label must then be associated with the view using the labelFor attribute or the setLabelFor() method.",
                "Assistive technologies need to know which labels are labelling, so they can convey that information to users.\n\nThe contentDescription attribute does not suffice as a relationship between a view and it's labeling view. Utilize the labelFor attribute to create the association for full accessibility by creating an association that assistive technologies can parse.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/control-labels");
    }
}
