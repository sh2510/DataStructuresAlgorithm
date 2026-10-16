package com.ds.p08_sorting.sortingalgorithm;

public class S05QuickSort {

    public static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex + 1; i <= endIndex; i++){
            if(array[i] < array[pivotIndex]){
                swapIndex++;
                swap(array, swapIndex, i);
            }
            System.out.println("pivot: " + printArray(array) + "  swapIndex: " + swapIndex + "  pivotIndex: " + pivotIndex);
        }
        swap(array, pivotIndex, swapIndex);
        System.out.println("exiting pivot: " + printArray(array) + "  swapIndex: " + swapIndex + "  pivotIndex: " + pivotIndex);
        return swapIndex;
    }

    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right){
        System.out.println("quick sort method: left = " + left + "  right= " + right + "  array=" + printArray(array));
        if(left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
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
