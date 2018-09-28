package com.deque.rulestubs;

public class RuleActiveViews extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.WCAG20_4_1_2;

    public RuleActiveViews() {
        super("Actionable views must have text that can be spoken by a screen reader.",
                "Checks for the actionable state of a view and ensures that such views have speakable text. This includes views that have their own text (such as Buttons) and views that present information in other ways (such as ImageViews).",
                "People with sensory limitations will experience situations of disability if non-text content is not ultimately conveyed as text. A visually impaired user needs to be able to understand the function of an active view. Users need clear, descriptive information on an active view's states, so they can interact with them as intended.\n\nOn active views provide non-text content as a text-based descriptions via the contentDescription attribute. This will allow the views to be reliably conveyed and interpreted.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/imageview-controls");
    }
}
