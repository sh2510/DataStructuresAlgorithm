package com.ds.p08_sorting.sortingalgorithm;

public class S02SelectionSort {
    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            System.out.print(printArray(array));
            int minIndex = i;
            for(int j = i; j < array.length - 1; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if(array[i] != array[minIndex]){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            System.out.print("  minIndex: " + minIndex + "  " + printArray(array) + "\n");
        }
    }

    private static StringBuilder printArray(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < array.length; i++){
            if(i == array.length - 1){
                sb.append(array[i] + "]");
            } else {
                sb.append((array[i]) + ",");
            }
        }
        return sb;
    }
}
