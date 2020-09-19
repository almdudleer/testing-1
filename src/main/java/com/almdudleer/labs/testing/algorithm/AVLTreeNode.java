package com.almdudleer.labs.testing.algorithm;

public class AVLTreeNode<V extends Comparable<V>> {
    private V value;
    private int height;
    private AVLTreeNode<V> leftNode;
    private AVLTreeNode<V> rightNode;


    public AVLTreeNode(V value) {
        this.value = value;
        height = 1;
    }

    public AVLTreeNode<V> insert(V value) {
        if (this.value.compareTo(value) > 0) {
            if (leftNode == null)
                leftNode = new AVLTreeNode<V>(value);
            else
                leftNode = leftNode.insert(value);
            // Вставили где-то слева от себя
        } else if (this.value.compareTo(value) < 0) {
            if (rightNode == null)
                rightNode = new AVLTreeNode<V>(value);
            else
                rightNode = rightNode.insert(value);
            // Вставили где-то справа от себя
        } else {
            System.out.println("Ну так-то ничего плохого, чтобы вставить дубликат, но лучше не надо");
        }
        return rebalance();
    }

    public AVLTreeNode<V> remove(V value) {
        if (this.value.compareTo(value) > 0) {
            if (leftNode != null)
                leftNode = leftNode.remove(value);
        } else if (this.value.compareTo(value) < 0) {
            if (rightNode != null)
                rightNode = rightNode.remove(value);
        } else {
            if (leftNode == null || rightNode == null) {
                return leftNode == null ? rightNode : leftNode;
            } else {
                AVLTreeNode<V> leftMax = leftNode.findMax();
                this.value = leftMax.value;
                leftNode = leftNode.remove(this.value);
            }
        }
        return rebalance();
    }

    public V find(V value) {
        if (this.value.compareTo(value) > 0) {
            if (leftNode != null)
                return leftNode.find(value);
            return null;
        } else if (this.value.compareTo(value) < 0) {
            if (rightNode != null)
                return rightNode.find(value);
            return null;
        }
        return this.value;

    }

    public void print() {
        print("");
    }

    public void print(String prefix) {
        System.out.println(prefix + "└-" + value);
        if (leftNode != null) {
            leftNode.print(prefix + "| ");
        } else {
            System.out.println(prefix + "| └-" + "X");
        }
        if (rightNode != null) {
            rightNode.print(prefix + "| ");
        } else {
            System.out.println(prefix + "| └-" + "X");
        }
    }

    private void updateHeight() {
        int rightHeight = rightNode == null ? 0 : rightNode.height;
        int leftHeight = leftNode == null ? 0 : leftNode.height;
        height = 1 + Math.max(rightHeight, leftHeight);
    }

    int getBalance() {
        int rightHeight = rightNode == null ? 0 : rightNode.height;
        int leftHeight = leftNode == null ? 0 : leftNode.height;
        return rightHeight - leftHeight;
    }

    private AVLTreeNode<V> rotateLeft() {
        AVLTreeNode<V> tmp = rightNode;
        rightNode = tmp.leftNode;
        tmp.leftNode = this;
        updateHeight();
        if (rightNode != null) {
            rightNode.updateHeight();
        }
        return tmp;
    }

    private AVLTreeNode<V> rotateRight() {
        AVLTreeNode<V> tmp = leftNode;
        leftNode = tmp.rightNode;
        tmp.rightNode = this;
        updateHeight();
        if (leftNode != null) {
            leftNode.updateHeight();
        }
        return tmp;
    }

    private AVLTreeNode<V> findMin() {
        if (leftNode != null) {
            return leftNode.findMin();
        }
        return this;
    }

    private AVLTreeNode<V> findMax() {
        if (rightNode != null) {
            return rightNode.findMax();
        }
        return this;
    }

    private AVLTreeNode<V> removeMin(AVLTreeNode<V> node) {
        return null;
    }

    private AVLTreeNode<V> rebalance() {
        updateHeight();
        int balance = getBalance();
        if (balance > 1) {
            if (rightNode.getBalance() < 0)
                rightNode = rightNode.rotateRight();
            return rotateLeft();
        } else if (balance < -1) {
            if (leftNode.getBalance() > 0)
                leftNode = leftNode.rotateLeft();
            return rotateRight();
        }
        return this;
    }
}
