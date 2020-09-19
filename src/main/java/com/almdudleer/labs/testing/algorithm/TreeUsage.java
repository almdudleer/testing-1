package com.almdudleer.labs.testing.algorithm;

public class TreeUsage {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(10);
        tree.insert(9);
        tree.insert(1);
        tree.insert(2);
        tree.insert(12);
        tree.insert(2412);
        tree.insert(3122);
        tree.insert(123);
        tree.insert(432);
        tree.insert(241);
        tree.insert(7853);
        tree.insert(76);
        tree.insert(15);
        tree.insert(456);
        tree.insert(1111);
        tree.print();
    }
}
