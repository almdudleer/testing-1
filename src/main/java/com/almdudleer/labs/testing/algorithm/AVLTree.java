package com.almdudleer.labs.testing.algorithm;

import java.util.Comparator;

public class AVLTree<V extends Comparable<V>> {
    AVLTreeNode<V> root;

    public AVLTree() {
    }

    public void insert(V value) {
        if (root == null) {
            root = new AVLTreeNode<>(value);
        } else {
            root = root.insert(value);
        }
    }

    public void remove(V value) {
        root = root.remove(value);
    }

    public void find(V value) {
        root.find(value);
    }

    public void print() {
        if (root != null)
            root.print();

    }
}
