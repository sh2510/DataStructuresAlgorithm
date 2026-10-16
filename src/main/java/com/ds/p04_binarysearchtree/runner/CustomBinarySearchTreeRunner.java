package com.ds.p04_binarysearchtree.runner;

import com.ds.p04_binarysearchtree.model.CustomBinarySearchTree;

public class CustomBinarySearchTreeRunner {
    public static void main(String[] args) {
        CustomBinarySearchTree binarySearchTree = new CustomBinarySearchTree();
        binarySearchTree.display();
        System.out.println("contains 76 ? " + binarySearchTree.contains(76));
        System.out.println("--------------\n");

        binarySearchTree.insert(47);
        binarySearchTree.display();
        System.out.println("--------------\n");

        binarySearchTree.insert(21);
        binarySearchTree.insert(76);
        binarySearchTree.insert(18);
        binarySearchTree.insert(52);
        binarySearchTree.insert(82);

        binarySearchTree.insert(27);
        binarySearchTree.display();
        System.out.println("--------------\n");
        binarySearchTree.rInsert(71);
        binarySearchTree.display();
        System.out.println("--------------\n");

        System.out.println("BFS           : " + binarySearchTree.breadthFirstSearch());
        System.out.println("--------------\n");

        System.out.println("DFS Preorder  : " + binarySearchTree.preOrderDFS());
        System.out.println("--------------\n");

        System.out.println("DFS Postorder : " + binarySearchTree.postOrderDFS());
        System.out.println("--------------\n");

        System.out.println("DFS Inorder   : " + binarySearchTree.inOrderDFS());
        System.out.println("--------------\n");

        System.out.println("contains 76 ? " + binarySearchTree.contains(76));
        System.out.println("contains 99 ? " + binarySearchTree.contains(99));
        System.out.println("contains 27 ? " + binarySearchTree.contains(27));
        System.out.println("recursive contains 27 ? " + binarySearchTree.rContains(27));
        System.out.println("recursive contains 88 ? " + binarySearchTree.rContains(88));

        System.out.println("--------------\n");
        binarySearchTree.deleteNode(18);
        binarySearchTree.display();
    }
}
