package com.ds.p07_heaps.runner;

import com.ds.p07_heaps.model.CustomHeap;

public class CustomHeapRunner {
    public static void main(String[] args) {
        CustomHeap heap = new CustomHeap();
        heap.insert(72);
        heap.insert(61);
        heap.insert(99);
        heap.insert(58);
        heap.insert(100);
        heap.insert(75);
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());

    }
}
