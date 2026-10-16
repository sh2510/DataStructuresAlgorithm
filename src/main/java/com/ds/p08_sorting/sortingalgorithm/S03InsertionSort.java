package com.ds.p08_sorting.sortingalgorithm;

public class S03InsertionSort {
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            System.out.print(printArray(array));
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && temp < array[j]){
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
            System.out.print("  i=" + i + "  j=" + j + "  " + printArray(array) + "\n");
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
