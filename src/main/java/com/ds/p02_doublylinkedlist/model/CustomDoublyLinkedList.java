package com.ds.p02_doublylinkedlist.model;

public class CustomDoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public CustomDoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public StringBuilder printList(){
        com.ds.p02_doublylinkedlist.model.Node tempNode = head;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if (i == length - 1) {
                sb.append(tempNode.getValue());
            } else {
                sb.append(tempNode.getValue()).append(", ");
            }
            tempNode = tempNode.getNext();
        }
        return sb;
    }

    public String printDetails(){
        return String.format(
                "linked list[ head: %-5s tail: %-5s length: %-5d list contents: {%s} ]",
                null == head ? "NA" : head.getValue(),
                null == tail ? "NA" : tail.getValue(),
                length,
                printList()
        );
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        length++;
    }

    public Node removeFromLast(){
        if(length == 0){
            return null;
        }
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        } else {
            tail = temp.getPrev();
            temp.setPrev(null);
            tail.setNext(null);

        }
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        } else {
            head = temp.getNext();
            temp.setNext(null);
            head.setPrev(null);
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp;
        if(index < (length / 2)){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.getNext();
            }
        } else {
            temp = tail;
            for(int i = length - 1; i > index; i--){
                temp = temp.getPrev();
            }
        }
        return temp;
    }

    public boolean set(int value, int index){
        Node temp = get(index);
        temp.setValue(value);
        return true;
    }

    public boolean insert(int value, int index){
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            if(index == 0){
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            } else if(index == length - 1){
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            } else {
                Node before = get(index - 1);
                Node after = before.getNext();
                before.setNext(newNode);
                newNode.setPrev(before);
                newNode.setNext(after);
                after.setPrev(newNode);
            }
        }
        length++;
        return true;
    }

    public Node remove(int index){
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(length == 0){
            return null;
        }
        Node nodeToRemove;
        if(index == 0){
            nodeToRemove = removeFirst();
        } else if (index == length - 1){
            nodeToRemove = removeFromLast();
        } else {
            //more readable code
            /*nodeToRemove = get(index);
            Node before = nodeToRemove.getPrev();
            Node after = nodeToRemove.getNext();
            before.setNext(after);
            after.setPrev(before);*/

            //ideal implementation
            nodeToRemove = get(index);
            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
            nodeToRemove.getPrev().setNext(nodeToRemove.getNext());

            nodeToRemove.setPrev(null);
            nodeToRemove.setNext(null);
            length--;
        }
        return nodeToRemove;
    }
}
