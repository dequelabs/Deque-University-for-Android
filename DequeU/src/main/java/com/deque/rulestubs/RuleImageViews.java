package com.deque.rulestubs;

public class RuleImageViews extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.WCAG20_1_1_1;

    public RuleImageViews() {
        super("ImageViews must have an informative contentDescription attribute or be wrapped within a layout that accessibly presents the same information as the image itself.",
                "This rule checks to make sure informative images have a contentDescription attribute and icons/bullets do not have content descriptions. For informative image, this rule checks to make sure the content description is not empty and does not simply repeat the content description of a visual label.",
                "If an image is meant to be informative, then it needs to have an informative content description so it can be used by TalkBack users.\n\nWithout a contentDescription attribute on the ImageView nothing will be announced except \"ImageView\", which can be confusing for a low vision user. Be mindful that nested contentDescriptions can bog down the TalkBack experience with repetitive information.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/imageview-controls");
    }
}
