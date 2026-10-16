package com.ds.p05_hashtable.runner;

import com.ds.p05_hashtable.model.CustomHashTable;

public class CustomHashTableRunner {
    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.set("nails", 1000);
        hashTable.set("tile", 500);
        hashTable.set("lumber", 400);
        hashTable.set("bolts", 800);
        hashTable.set("screws", 100);
        hashTable.set("paint", 200);

        hashTable.printHashTable();

        System.out.println(hashTable.get("lumber"));

        System.out.println(hashTable.keys());
    }
}
