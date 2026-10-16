package com.ds.p03_stacksandqueues.model;

public class CustomStack {
    private Node top;
    private int height;

    public CustomStack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public StringBuilder printList(){
        Node tempNode = top;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++){
            if (i == height - 1) {
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
                "stack[ top: %-5s height: %-5d list contents: {%s} ]",
                null == top ? "NA" : top.getValue(),
                height,
                printList()
        );
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(height == 0){
            return null;
        } else {
            Node temp = top;
            top = temp.getNext();
            temp.setNext(null);
            height--;
            return temp;
        }
    }
}
