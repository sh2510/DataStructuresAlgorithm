package com.ds.p01_linkedlist.runner;

import com.ds.p01_linkedlist.model.CustomLinkedList;

public class LinkedListRunner {
    public static void main(String[] args) {
        System.out.println("Hello from Linked List Runner!");

        CustomLinkedList customLinkedList = new CustomLinkedList(25);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(6);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(10);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFromLast();
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFromLast();
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFromLast();
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(21);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(24);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.prepend(44);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFirst();
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFirst();
        System.out.println(customLinkedList.printDetails());

        customLinkedList.removeFirst();
        System.out.println(customLinkedList.printDetails());


        customLinkedList.append(99);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(76);
        System.out.println(customLinkedList.printDetails());

        System.out.println(customLinkedList.get(0));
        System.out.println(customLinkedList.get(1));

        customLinkedList.set(44, 1);
        System.out.println(customLinkedList.printDetails());
        customLinkedList.set(55, 0);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.append(66);
        System.out.println(customLinkedList.printDetails());

        customLinkedList.insert(77, 1);
        System.out.println(customLinkedList.printDetails());

        System.out.println(customLinkedList.remove(3).getValue());
        System.out.println(customLinkedList.printDetails());

        customLinkedList.reverse();
        System.out.println(customLinkedList.printDetails());
    }
}
