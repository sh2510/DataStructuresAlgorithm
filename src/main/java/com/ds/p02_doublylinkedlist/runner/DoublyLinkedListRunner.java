package com.ds.p02_doublylinkedlist.runner;

import com.ds.p02_doublylinkedlist.model.CustomDoublyLinkedList;

public class DoublyLinkedListRunner {
    public static void main(String[] args) {
        CustomDoublyLinkedList doublyLinkedList = new CustomDoublyLinkedList(23);
        System.out.println(doublyLinkedList.printDetails());

        doublyLinkedList.append(45);
        System.out.println(doublyLinkedList.printDetails());

        doublyLinkedList.append(70);
        System.out.println(doublyLinkedList.printDetails());

        doublyLinkedList.append(89);
        System.out.println(doublyLinkedList.printDetails());

        System.out.println(doublyLinkedList.removeFromLast().getValue());
        System.out.println(doublyLinkedList.printDetails());

        doublyLinkedList.prepend(33);
        System.out.println(doublyLinkedList.printDetails());

        System.out.println(doublyLinkedList.removeFirst().getValue());
        System.out.println(doublyLinkedList.printDetails());

        System.out.println(doublyLinkedList.get(0).getValue());

        doublyLinkedList.set(56, 2);
        System.out.println(doublyLinkedList.printDetails());

        doublyLinkedList.insert(99, 0);
        System.out.println(doublyLinkedList.printDetails());

        System.out.println(doublyLinkedList.remove(3).getValue());
        System.out.println(doublyLinkedList.printDetails());
    }
}
