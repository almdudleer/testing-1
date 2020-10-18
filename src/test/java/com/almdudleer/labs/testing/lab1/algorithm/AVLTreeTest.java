package com.almdudleer.labs.testing.lab1.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class AVLTreeTest {
    public static final String TEST_RESOURCE_ROOT = "src/test/resources/algorithm";

    private static Stream<Path> findTestFiles() throws IOException {
        return Files.find(Paths.get(TEST_RESOURCE_ROOT, "snapshot_tests"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile() && filePath.getFileName().toString().endsWith(".json")
        );
    }

    @ParameterizedTest(name = "Snapshot test from {0}")
    @MethodSource("findTestFiles")
    void snapshotTest(Path snapshotsFile) throws IOException {
        AVLTree<Double> avlTree = new AVLTree<>();
        List<AVLTreeTestSnapshot> snapshots = AVLTreeTestSnapshot.parseSnapshots(snapshotsFile);
        for (AVLTreeTestSnapshot snapshot : snapshots) {
            AVLTreeTestSnapshot.applySnapshot(avlTree, snapshot);
        }
    }
}