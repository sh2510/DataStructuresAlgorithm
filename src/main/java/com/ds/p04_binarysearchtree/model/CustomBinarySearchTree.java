package com.ds.p04_binarysearchtree.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CustomBinarySearchTree {
    private Node root;

    public void display() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println("Root: " + root.getValue());
        displayTree(root, 0);
    }

    private void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }
        displayTree(node.getRight(), level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getValue());
        displayTree(node.getLeft(), level + 1);
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (null == root) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) {
                return false;
            }
            if (newNode.getValue() > temp.getValue()) {
                if (null == temp.getRight()) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            } else {
                if (null == temp.getLeft()) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            }
        }
    }

    public boolean contains(int value){
        Node temp = root;
        while(null != temp){
            if(value > temp.getValue()){
                System.out.println("greater than :: value: " + value + " comparing with: " + temp.getValue());
                temp = temp.getRight();
            } else if(value < temp.getValue()){
                System.out.println("less than    :: value: " + value + " comparing with: " + temp.getValue());
               temp = temp.getLeft();
            } else {
                System.out.println("equal        :: value: " + value + " comparing with: " + temp.getValue());
                return true;
            }
        }
        return false;
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value){
        if(null == currentNode){
            return false;
        }
        if(value == currentNode.getValue()){
            return true;
        }
        if(value < currentNode.getValue()){
            return rContains(currentNode.getLeft(), value);
        } else {
            return rContains(currentNode.getRight(), value);
        }
    }

    public void rInsert(int value){
        if(null == root){
            root = new Node(value);
        }
        rInsert(this.root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if(null == currentNode){
            return new Node(value);
        }
        if(value < currentNode.getValue()){
            currentNode.setLeft(rInsert(currentNode.getLeft(), value));
        } else if(value > currentNode.getValue()){
            currentNode.setRight(rInsert(currentNode.getRight(), value));
        }
        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(this.root, value);
    }

    private Node deleteNode(Node currentNode, int value){
        if(null == currentNode){
            return null;
        }

        if(value < currentNode.getValue()){
            currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
        } else if(value > currentNode.getValue()){
            currentNode.setRight(deleteNode(currentNode.getRight(), value));
        } else {
            // when value equal to currentNode.getValue
            // 4 different situations
            // leaf node
            if(null == currentNode.getLeft() && null == currentNode.getRight()){
                return null;
            }
            // has a node on right but not on left
            else if(null == currentNode.getLeft() && null != currentNode.getRight()){
                currentNode = currentNode.getRight();
            }
            // has a node on left but not on the right
            else if(null == currentNode.getRight() && null != currentNode.getLeft()){
                currentNode = currentNode.getLeft();
            }
            // has a node on each side
            else {
                int subTreeMin = findMinValue(currentNode.getRight()).getValue();
                currentNode.setValue(subTreeMin);
                currentNode.setRight(deleteNode(currentNode.getRight(), subTreeMin));
            }
        }
        return currentNode;
    }

    private Node findMinValue(Node currentNode){
        if(null == currentNode.getLeft()){
            return currentNode;
        }
        return findMinValue(currentNode.getLeft());
    }

    public ArrayList<Integer> breadthFirstSearch(){
        Node currentNode = this.root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.remove();
            resultList.add(currentNode.getValue());
            if(null != currentNode.getLeft()){
                queue.add(currentNode.getLeft());
            }
            if(null != currentNode.getRight()){
                queue.add(currentNode.getRight());
            }
        }
        return resultList;
    }

    public ArrayList<Integer> preOrderDFS(){
        ArrayList<Integer> resultList = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                resultList.add(currentNode.getValue());
                if(null != currentNode.getLeft()){
                    new Traverse(currentNode.getLeft());
                }
                if(null != currentNode.getRight()){
                    new Traverse(currentNode.getRight());
                }
            }
        }
        new Traverse(root);
        return resultList;
    }

    public ArrayList<Integer> postOrderDFS(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(null != currentNode.getLeft()){
                    new Traverse(currentNode.getLeft());
                }
                if(null != currentNode.getRight()){
                    new Traverse(currentNode.getRight());
                }
                result.add(currentNode.getValue());
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> inOrderDFS(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(null != currentNode.getLeft()){
                    new Traverse(currentNode.getLeft());
                }
                result.add(currentNode.getValue());
                if(null != currentNode.getRight()){
                    new Traverse(currentNode.getRight());
                }
            }
        }
        new Traverse(root);
        return result;
    }

}
