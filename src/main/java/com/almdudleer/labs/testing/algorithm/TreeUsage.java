package com.almdudleer.labs.testing.algorithm;

public class TreeUsage {
    private static void applyAction(String action, Double value, AVLTree<Double> tree) {
        System.out.println(tree.getJsonSnapshot());
        switch (action) {
            case "insert":
                tree.insert(value);
                break;
            case "remove":
                tree.remove(value);
                break;
            case "end":
                break;
        }
        if (!action.equals("end")) {
            System.out.println("### " + action + " " + value);
        } else {
            System.out.println("###");
        }
    }

    public static void main(String[] args) {
        AVLTree<Double> tree = new AVLTree<>();
        applyAction("insert", 3.0, tree);
        applyAction("insert", 5.0, tree);
//        applyAction("remove", 3.0, tree);
        applyAction("insert", 1.0, tree);
        applyAction("insert", 2.0, tree);
//        applyAction("remove", 1.0, tree);
//        applyAction("insert", 12.0, tree);
//        applyAction("remove", 12.0, tree);
        applyAction("end", 0.0, tree);
//        tree.insert(2412);
//        tree.insert(3122);
//        tree.insert(123);
//        tree.insert(432);
//        tree.insert(241);
//        tree.insert(7853);
//        tree.insert(76);
//        tree.insert(15);
//        tree.insert(456);
//        tree.insert(1111);
        System.out.println("Ищем 7, вот же она:" + tree.find(7.0));
        tree.remove(7.0);
        tree.print();
        System.out.println("Ищем 7, вот же она:" + tree.find(7.0));
    }
}
