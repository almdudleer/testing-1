package com.almdudleer.labs.testing.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AVLTreeTest {
    public static final String TEST_RESOURCE_ROOT = "src/test/resources/algorithm";

    private static Stream<Path> insertTestFiles() throws IOException {
        return Files.list(Paths.get(TEST_RESOURCE_ROOT, "insert_tests"));
    }

    private static Stream<Path> removeTestFiles() throws IOException {
        return Files.list(Paths.get(TEST_RESOURCE_ROOT, "remove_tests"));
    }

    private static Stream<Path> findTestFiles() throws IOException {
        return Files.list(Paths.get(TEST_RESOURCE_ROOT, "find_tests"));
    }

    @ParameterizedTest(name = "Insert test {0}")
    @MethodSource("insertTestFiles")
    void insert(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        List<AVLTreeTestSnapshot> snapshots = parseSnapshots(snapshotsFile);
        for (AVLTreeTestSnapshot snapshot : snapshots) {
            applySnapshot(avlTree, snapshot);
        }
    }

    @ParameterizedTest(name = "Remove test {0}")
    @MethodSource("removeTestFiles")
    void remove(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        for (AVLTreeTestSnapshot snapshot : parseSnapshots(snapshotsFile)) {
            applySnapshot(avlTree, snapshot);
        }
    }

    @ParameterizedTest(name = "Find test {0}")
    @MethodSource("findTestFiles")
    void find(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        for (AVLTreeTestSnapshot snapshot : parseSnapshots(snapshotsFile)) {
            applySnapshot(avlTree, snapshot);
        }
    }

    private static List<AVLTreeTestSnapshot> parseSnapshots(Path file) throws IOException {
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

    private static void applySnapshot(AVLTree<Double> avlTree, AVLTreeTestSnapshot snapshot) {
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
                    Double expectedResult = Double.parseDouble(snapshot.nextActionExpectedResult);
                    assertEquals(expectedResult, avlTree.find(value));
                    break;
            }
        }
    }
}