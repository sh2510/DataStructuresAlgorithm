package com.ds.p07_heaps.model;

import java.util.ArrayList;
import java.util.List;

public class CustomHeap {
    private List<Integer> heap;

    public CustomHeap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(this.heap); // returning a copy and not the actual heap
    }

    private int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index){
        return 2 * index + 2;
    }

    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while(currentIndex > 0 && (heap.get(currentIndex) > heap.get(getParentIndex(currentIndex)))){
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public Integer remove(){
        if(this.heap.size() == 0){
            return null;
        }
        if(this.heap.size() == 1){
            return this.heap.remove(0);
        }
        int maxValue = heap.get(0);
        int lastItem = this.heap.remove(this.heap.size() - 1);
        this.heap.set(0, lastItem);
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index){
        while(true) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            Integer indexToBeSwapped = null;
            if(leftIndex < heap.size() && this.heap.get(leftIndex) > this.heap.get(rightIndex)){
                indexToBeSwapped = leftIndex;
            } else if(rightIndex < heap.size() && this.heap.get(rightIndex) > this.heap.get(leftIndex)){
                indexToBeSwapped = rightIndex;
            }
            if(null != indexToBeSwapped && this.heap.get(index) < this.heap.get(indexToBeSwapped)) {
                swap(index, indexToBeSwapped);
                index = indexToBeSwapped;
            } else {
                return;
            }
        }
    }

}
