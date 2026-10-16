package com.ds.p05_hashtable.model;

import java.util.ArrayList;
import java.util.List;

public class CustomHashTable {
    private int size = 7;
    private Node[] dataMap;

    public CustomHashTable(){
        this.dataMap = new Node[this.size];
    }

    public void printHashTable(){
        for (int i = 0; i < size; i++){
            System.out.print(i + ":");
            Node temp = dataMap[i];
            while(null != temp){
                System.out.print("  {key=" + temp.getKey() + ", value=" + temp.getValue() + " }");
                temp = temp.getNext();
            }
            System.out.print("\n");
        }
    }

    private int customHash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + (asciiValue * 23)) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = customHash(key);
        Node newNode = new Node(key, value);
        if(null == dataMap[index]) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while(null != temp.getNext()){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public int get(String key) {
        int index = customHash(key);
        int result = 0;
        Node temp = dataMap[index];
        while (null != temp) {
            if (key.equals(temp.getKey())) {
                result = temp.getValue();
                break;
            } else {
                temp = temp.getNext();
            }
        }
        return result;
    }

    public List<String> keys(){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while(null != temp){
                result.add(temp.getKey());
                temp = temp.getNext();
            }
        }
        return result;
    }
}
