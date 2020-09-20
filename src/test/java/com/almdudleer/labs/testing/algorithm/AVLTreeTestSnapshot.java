package com.almdudleer.labs.testing.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AVLTreeTestSnapshot {
    String json;
    String nextAction;
    String nextActionArgument;

    public AVLTreeTestSnapshot(String json, String nextAction, String nextActionArgument) {
        Set<String> goodActions = new HashSet<>(Arrays.asList("insert", "remove", null));
        if (!goodActions.contains(nextAction)) {
            throw new IllegalArgumentException("Action " + nextAction + " not recognized");
        }
        this.json = json.replace(" ", "");
        this.nextAction = nextAction;
        this.nextActionArgument = nextActionArgument;
    }
}
