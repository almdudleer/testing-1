package com.almdudleer.labs.testing.algorithm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        if (root == null)
            return null;
        return root.find(value);

    }

    public void print() {
        System.out.println(getJsonSnapshot());
    }

    public String getJsonSnapshot() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(root);
    }
}
