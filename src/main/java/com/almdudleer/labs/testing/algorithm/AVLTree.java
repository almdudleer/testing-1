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
        if (root != null)
            root = root.remove(value);
    }

    public V find(V value) {
        return root.find(value);
    }

    public void print() {
        if (root != null)
            root.print();

    }
}
