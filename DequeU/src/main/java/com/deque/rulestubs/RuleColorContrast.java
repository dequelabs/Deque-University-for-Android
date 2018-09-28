package com.deque.rulestubs;

public class RuleColorContrast extends Rule {
    final static SuccessCriteria successCriteria = SuccessCriteria.WCAG20_1_4_3;

    public RuleColorContrast() {
        super("In accordance with WCAG 2 AA contrast ratio thresholds all text elements must have sufficient contrast between text in the foreground and background.",
                "This rule identifies the text color and background color in a node with text.  The rule will throw an exception if a single background color is not found.  Then it computes the color contrast ratio between the background and text colors.",
                "Some low vision users experience low contrast as well. For them, there aren't very many bright or dark areas in their sight, so everything has similar brightness. This makes it harder to distinguish outlines, borders, edges, and fine details. Consequently, text that is too close in luminance (brightness) to the background can be hard to read.",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/color-contrast");

    }
}
