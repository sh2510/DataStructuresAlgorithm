package com.ds.p08_sorting.sortingalgorithm;

public class S01BubbleSort {
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for(int j = 0; j < (array.length - 1) - i; j++){
                if(array[j] > array[j+ 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println(printArray(array));
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
