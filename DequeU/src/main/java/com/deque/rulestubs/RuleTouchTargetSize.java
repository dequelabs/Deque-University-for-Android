package com.deque.rulestubs;

public class RuleTouchTargetSize extends Rule {
    static final int MINIMUM_ALLOWED_SIZE = 48;
    static final SuccessCriteria successCriteria = SuccessCriteria.PLATFORM;

    public RuleTouchTargetSize() {
        super("Active views must be at least " + MINIMUM_ALLOWED_SIZE + " density independent pixels (dp) by " + MINIMUM_ALLOWED_SIZE + " dp.",
                "Checks the touchable area of active views meet minimum size requirements.",
                "Many people have difficulty interacting with small touch targets on a device\'s screen. This could be due a variety of reasons, such as having large fingers, or a motor or visual impairment, or not having fingers at all. Any and all of these users benefit from larger touch targets.\n\nHere is a short list of views to consider when thinking about touch target size accessibility:\n\t• Links\n\t• Menus\n\t• Submit Buttons\n\t• Checkboxes\n\t• Radio buttons\n\t• Text input fields\n\t• Select fields (combo boxes)\n\t• Custom views (i.e. media-player buttons)",
                successCriteria,
                "https://dequeuniversity.com/rules/attest-android/1.0/touch-target-size");
    }
}
