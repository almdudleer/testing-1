package com.almdudleer.labs.testing.algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTreeTestSnapshot {
    String json;
    String nextAction;
    String nextActionArgument;
    String nextActionExpectedResult;

    public AVLTreeTestSnapshot(String json, String nextAction, String nextActionArgument, String nextActionExpectedResult) {
        Set<String> goodActions = new HashSet<>(Arrays.asList("insert", "remove", "find", null));
        if (!goodActions.contains(nextAction)) {
            throw new IllegalArgumentException("Action " + nextAction + " not recognized");
        }
        this.json = json.replace(" ", "");
        this.nextAction = nextAction;
        this.nextActionArgument = nextActionArgument;
        this.nextActionExpectedResult = nextActionExpectedResult;
    }

    public static List<AVLTreeTestSnapshot> parseSnapshots(Path file) throws IOException {
        Pattern commandRegex = Pattern.compile("###( (?<command>\\w+))?( (?<argument>\\S+))?( -> (?<result>\\S+))?");
        List<AVLTreeTestSnapshot> snapshots = new ArrayList<>();
        StringBuilder currentSnapshotText = new StringBuilder();
        for (String line : Files.readAllLines(file)) {
            Matcher m = commandRegex.matcher(line);
            if (m.find()) {
                String action = m.group("command");
                String argument = m.group("argument");
                String expectedResult = m.group("result");
                snapshots.add(new AVLTreeTestSnapshot(
                        currentSnapshotText.toString(),
                        action,
                        argument,
                        expectedResult
                ));
                currentSnapshotText = new StringBuilder();
            } else {
                currentSnapshotText.append(line);
            }
        }
        return snapshots;
    }

    public static void applySnapshot(AVLTree<Double> avlTree, AVLTreeTestSnapshot snapshot) {
        assertEquals(snapshot.json, avlTree.getJsonSnapshot());
        if (snapshot.nextAction != null) {
            Double value = Double.parseDouble(snapshot.nextActionArgument);
            switch (snapshot.nextAction) {
                case "insert":
                    avlTree.insert(value);
                    break;
                case "remove":
                    avlTree.remove(value);
                    break;
                case "find":
                    Double expectedResult = null;
                    if (!snapshot.nextActionExpectedResult.equals("null")) {
                        expectedResult = Double.parseDouble(snapshot.nextActionExpectedResult);
                    }
                    assertEquals(expectedResult, avlTree.find(value));
                    break;
            }
        }
    }
}
