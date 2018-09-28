package com.deque.rulestubs;

import java.io.Serializable;

public abstract class Rule implements Serializable {
    public final String description;
    public final String helpUrl;
    public final String helpText;
    public final String importance;
    public final String id;
    public final SuccessCriteria sc;

    Rule(String description, String helpText, String importance, SuccessCriteria sc, String helpUrl) {

        this.id = getClass().getSimpleName();
        this.description = description;
        this.sc = sc;
        this.helpUrl = helpUrl;
        this.helpText = helpText;
        this.importance = importance;
    }
}
