package com.ds.p01_linkedlist.model;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public CustomLinkedList (int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public StringBuilder printList(){
        Node tempNode = head;
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
        if (length == 0){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

    public Node removeFromLast(){
        if(length == 0){
            return null;
        } else if(length == 1){
            head = null;
            tail = null;
            length--;
            return null;
        } else {
            Node temp = head;
            Node pre = head;
            for(int i = 0; i < getLength(); i++){
                if(null != temp.getNext()){
                    pre = temp;
                }
                if(temp.getNext() != null) {
                    temp = temp.getNext();
                }
            }
            pre.setNext(null);
            tail = pre;
            length--;
            return temp;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0){
            return null;
        } else if (length == 1){
            head = null;
            tail = null;
            length--;
            return null;
        } else {
            Node nodeToRemove = head;
            head = head.getNext();
            nodeToRemove.setNext(null);
            length--;
            return nodeToRemove;
        }
    }

    public int get(int targetIndex){
        Integer resultValue = null;
        if(targetIndex >= length || targetIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < length; i++){
            if(i == targetIndex){
                resultValue = temp.getValue();
                break;
            }
            temp = temp.getNext();
        }
        return resultValue;
    }

    public boolean set(int value, int index){
        boolean actionCompleted = false;
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int i = 0; i < length; i++){
            if(i == index){
                temp.setValue(value);
                actionCompleted = true;
                break;
            }
            temp = temp.getNext();
        }
        return actionCompleted;
    }

    public boolean insert(int value, int index){
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            prepend(value);
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            for (int i = 0; i < length; i++){
                if(i == index - 1){
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                    break;
                }
                temp = temp.getNext();
            }
            length++;
        }
        return true;
    }

    public Node remove(int index){
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            return removeFirst();
        } else if (index == length - 1){
            return removeFromLast();
        } else {
            Node temp = head;
            Node pre = head;
            for (int i = 0; i < length; i++) {
                if (null != temp.getNext()) {
                    pre = temp;
                }
                temp = temp.getNext();
                if (i == index - 1) {
                    pre.setNext(temp.getNext());
                    temp.setNext(null);
                    break;
                }
            }
            length--;
            return temp;
        }
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = null;

        for(int i = 0; i < length; i++){
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }
}
