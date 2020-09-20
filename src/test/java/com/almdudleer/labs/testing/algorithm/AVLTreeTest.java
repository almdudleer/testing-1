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

    private static Stream<Path> insertTestFiles() throws IOException {
        return Files.list(Paths.get("src/test/resources/algorithm/insert_tests"));
    }

    private static Stream<Path> removeTestFiles() throws IOException {
        return Files.list(Paths.get("src/test/resources/algorithm/remove_tests"));
    }

    @ParameterizedTest(name="Test {0}")
    @MethodSource("insertTestFiles")
    void insert(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        for (AVLTreeTestSnapshot snapshot : readSnapshots(snapshotsFile)) {
            applySnapshot(avlTree, snapshot);
        }
    }

    @ParameterizedTest(name="#{index} - Test from {0}")
    @MethodSource("removeTestFiles")
    void remove(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        for (AVLTreeTestSnapshot snapshot : readSnapshots(snapshotsFile)) {
            applySnapshot(avlTree, snapshot);
        }
    }

    private static List<AVLTreeTestSnapshot> readSnapshots(Path file) throws IOException {
        Pattern commandRegex = Pattern.compile("### (\\w+) (.+)");
        List<String> lines = Files.readAllLines(file);
        List<AVLTreeTestSnapshot> snapshots = new ArrayList<>();
        StringBuilder currentSnapshotText = new StringBuilder();
        for (String line : lines) {
            if (line.startsWith("###")) {
                Matcher m = commandRegex.matcher(line);
                if (m.find()) {
                    snapshots.add(new AVLTreeTestSnapshot(
                            currentSnapshotText.toString(),
                            m.group(1),
                            m.group(2)
                    ));
                }
                currentSnapshotText = new StringBuilder();
            } else {
                currentSnapshotText.append(line);
            }
        }
        return snapshots;
    }

     private static void applySnapshot(AVLTree<Double> avlTree, AVLTreeTestSnapshot snapshot) {
         assertEquals(snapshot.json, avlTree.getJsonSnapshot());
         Double value = Double.parseDouble(snapshot.nextActionArgument);
         switch (snapshot.nextAction) {
             case "insert":
                 avlTree.insert(value);
                 break;
             case "remove":
                 avlTree.remove(value);
                 break;
         }
     }
}