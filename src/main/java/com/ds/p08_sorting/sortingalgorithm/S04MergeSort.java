package com.ds.p08_sorting.sortingalgorithm;

import java.util.Arrays;

public class S04MergeSort {

    public static int[] merge(int[] array1, int[] array2){
        int[] combined = new int[array1.length + array2.length];
        int index = 0; // index of combined array
        int i = 0;     // index of 1st array
        int j = 0;     // index of 2nd array

        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
            System.out.print("array1: " + printArray(array1) + "  array2: " + printArray(array2) + "  combined: " + printArray(combined) + "  i=" + i + "  j=" + j + "  combinedIndex=" + index + "\n");
        }
        while(i < array1.length){
            combined[index] = array1[i];
            index++;
            i++;
        }
        System.out.println("after combing from 1st array: " + printArray(combined));
        while(j < array2.length){
            combined[index] = array2[j];
            index++;
            j++;
        }
        System.out.println("after combing from 2nd array: " + printArray(combined));
        return combined;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        System.out.println("array: " + printArray(array)+ "  left: " + printArray(left) + "  right: " + printArray(right));

        return merge(left, right);
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
