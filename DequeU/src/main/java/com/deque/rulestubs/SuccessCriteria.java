package com.deque.rulestubs;

enum SuccessCriteria {

    BEST_PRACTICE("BestPractice"),
    PLATFORM("Platform"),
    WCAG20_1_1_1("1.1.1"),
    WCAG20_1_3_1("1.3.1"),
    WCAG20_1_4_3("1.4.3"),
    WCAG20_2_1_1("2.1.1"),
    WCAG20_4_1_2("4.1.2"),
    UNDER_REVIEW("under review"),
    WCAG21_2_5_5("2.5.5"),
    DEPRECATED("deprecated");

    public final String text;

    SuccessCriteria(final String text) {
        this.text = text;
    }
}
