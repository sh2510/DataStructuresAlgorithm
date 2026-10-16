package com.ds.p03_stacksandqueues.model;

public class CustomQueue {
    private Node first;
    private Node last;
    private int length;

    public CustomQueue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public StringBuilder printList(){
        Node tempNode = first;
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
                "queue[ first: %-5s last: %-5s length: %-5d queue contents: {%s} ]",
                null == first ? "NA" : first.getValue(),
                null == last ? "NA" : last.getValue(),
                length,
                printList()
        );
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        } else {
            Node temp = first;
            if(null == first.getNext()){
                last = null;
            }
            first = temp.getNext();
            temp.setNext(null);
            length--;
            return temp;
        }
    }
}
